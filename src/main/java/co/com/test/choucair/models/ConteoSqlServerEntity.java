package co.com.test.choucair.models;

import java.util.List;

public class ConteoSqlServerEntity {

    private static ConteoQVF conteoQVF;

    private ConteoSqlServerEntity() {}

    public static void loadDataForTransaction(List<String> data) {
        withConteoQVF(data);

    }

    public static ConteoQVF getConteoQVF() {
        return conteoQVF;
    }


    public static void withConteoQVF(List<String> data) {

        ConteoQVF conteoQVF = new ConteoQVF();
        conteoQVF.setNombreqvf(data.get(0));
        ConteoSqlServerEntity.conteoQVF = conteoQVF;
    }


}
