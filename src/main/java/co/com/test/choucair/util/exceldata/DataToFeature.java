package co.com.test.choucair.util.exceldata;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import co.com.test.choucair.exceptions.BackEndException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class DataToFeature {

	protected static String data;
	protected static String idCaso = null;
	protected static int filaSeleccionada;
	protected static boolean foundHashTag = false;
	protected static boolean featureData = false;

	protected static String sheetName;
	protected static String excelFilePath;

	private DataToFeature() {
	}



	private static List<String> setExcelDataToFeature(File featureFile) throws IOException {
		List<String> fileData = new ArrayList<>();
		try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(
				new BufferedInputStream(new FileInputStream(featureFile)), StandardCharsets.UTF_8))) {
			foundHashTag = false;
			featureData = false;

			while ((data = buffReader.readLine()) != null) {
				sheetName = null;
				excelFilePath = null;

				if (data.trim().contains("##@externaldata")) {
					foundHashTag = true;
					fileData = getDataExcel(fileData);
				}
				if (foundHashTag) {

					foundHashTag = false;
					featureData = true;

				} else {
					if ((data.startsWith("|") || data.endsWith("|")) && featureData) {
						continue;
					}
					featureData = false;
					fileData.add(data);
				}
			}
		}
		return fileData;
	}


	private static List<File> listOfFeatureFiles(File folder) {

		List<File> featureFiles = null;
		try {
			featureFiles = new ArrayList<>();
			if (folder.getName().endsWith(".feature")) {
				featureFiles.add(folder);
			} else {

				for (File fileEntry : folder.listFiles()) {
					if (fileEntry.isDirectory()) {
						featureFiles.addAll(listOfFeatureFiles(fileEntry));
					} else {
						if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
							featureFiles.add(fileEntry);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new BackEndException(e);
		}
		return featureFiles;
	}


	public static void overrideFeatureFiles(String featuresDirectoryPath)
			throws IOException {

		List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));

		try {
			for (File featureFile : listOfFeatureFiles) {

				List<String> featureWithExcelData = setExcelDataToFeature(featureFile);

				try (BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));) {
					for (String string : featureWithExcelData) {
						writer.write(string);
						writer.write("\n");
					}
				}
			}
		} catch (IOException e) {
			throw new BackEndException(e);
		}

	}

	private static List<String> getDataExcel(List<String> fileData) {
		int pos = 0;
		boolean esRangoDefinido = false;
		boolean esUnRango = false;
		boolean esMultiple = false;
		String cellData = "";
		String [] dataVectorRango = null;

		List<Map<String, String>> excelData = null;

		try {
			String[] dataVector = data.trim().split("@");
			excelFilePath = dataVector[2];
			sheetName = dataVector[3];
			if (dataVector.length == 4) {
				esUnRango = true;
			}
			if (dataVector.length == 5) {
				if (dataVector[4].contains("-")) {
					dataVectorRango = dataVector[4].trim().split("-");
					esRangoDefinido=true;
					filaSeleccionada = Integer.parseInt(dataVectorRango[pos]) - 1;

				} else {
					if (dataVector[4].contains(",")) {
						dataVectorRango = dataVector[4].trim().split(",");
						esUnRango=true;
						esMultiple=true;
						filaSeleccionada = Integer.parseInt(dataVectorRango[pos]) - 1;

					} else {

						filaSeleccionada = Integer.parseInt(dataVector[4])-1;
					}

				}

			}
			fileData.add(data);

			excelData = new LectorExcel().getData(excelFilePath, sheetName);

			for (int rowNumber = filaSeleccionada; rowNumber < excelData.size()-1; rowNumber++) {

				for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
					if (dataVectorRango==null)
					{
						if(rowNumber==filaSeleccionada-1 && !esUnRango)
						{
							cellData = cellData + "   |" + mapData.getValue();
						}else{
							cellData = cellData + "   |" + mapData.getValue();
						}
					}else{

						if(esRangoDefinido)
						{
							if(rowNumber<Integer.parseInt(dataVectorRango[1]) )
							{
								cellData = cellData + "   |" + mapData.getValue();
							}

						}else{
							if(rowNumber+1==Integer.parseInt(dataVectorRango[pos])   && !esUnRango)
							{
								cellData = cellData + "   |" + mapData.getValue();
							}

						}
					}
				}
				fileData.add(cellData + "|");
				if (!esUnRango && !esRangoDefinido ) {
					rowNumber=excelData.size();
				}
				if(esMultiple)
				{
					if(pos+1<dataVectorRango.length)
					{
						filaSeleccionada=Integer.parseInt(dataVectorRango[pos+1])-1;
						rowNumber=filaSeleccionada-1;
						pos++;
					}else{
						rowNumber=excelData.size()-1;
					}

				}
				if(esRangoDefinido)
				{
					if(rowNumber+1==Integer.parseInt(dataVectorRango[1]))
					{
						rowNumber=excelData.size()-1;
						pos++;
					}else{
						pos++;
					}

				}


			}
		} catch (InvalidFormatException |IOException e) {
			throw new BackEndException(e);
		}

		return fileData;
	}
}
