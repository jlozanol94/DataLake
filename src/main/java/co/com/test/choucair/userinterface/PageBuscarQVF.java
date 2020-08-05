package co.com.test.choucair.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PageBuscarQVF extends PageObject {

    public static Target BTN_BUSCAR = Target.the("Buscar QVF").located(By.xpath("//*[@id=\"q-hub-toolbar\"]/div[1]/div[2]/div/button/span"));
    public static Target TXTQVF = Target.the("Ingresar nombre de QVF").located(By.xpath("//*[@id=\"q-hub-toolbar\"]/div[1]/div[2]/div[1]/input"));
    public static Target BTNQVF = Target.the("Click en el QVF").located(By.xpath("//*[@id=\"q-route-area\"]/div/div[2]/div/ul/li/div/div[3]"));
    public static Target BTN_CARGAR_DATOS = Target.the("Click en CARGAR DATOS").located(By.xpath("//*[@id=\"qv-page-container\"]/div[1]/div/div/div[3]/div[2]/button/span[2]"));
    public static Target BTNCLOSE= Target.the("Click en CERRAR").located(By.xpath("//button[text()='Cerrar']"));
    public static Target BTN_COMPARE_PLAINS = Target.the("Click Comparar Planos").located(By.xpath("//div[@class='lui-dialog__header ng-scope']/button"));
    public static Target BTN_OPCIONES = Target.the("Click OPCIONES").located(By.xpath("//*[@id=\"qs-toolbar-container\"]/div[1]/div[2]/ul/li[1]/div/div[2]"));
    public static Target BTN_DATA_EDITOR = Target.the("Click EDITOR DE DATOS").located(By.xpath("//*[@id=\"rlui-popover-1\"]/div[1]/ul/li[2]"));
    public static Target Conec = Target.the("Click EDITOR DE DATOS").located(By.xpath("//*[@id=\"qs-toolbar-container\"]/div/div[3]/div[2]/button"));


}
