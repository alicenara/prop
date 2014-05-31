
package propLlibreria.Interficie;
import java.util.*;
import propLlibreria.Domini.CtrlDominiInterficie;


public final class CtrlInterficie {
    private static VistaPrincipal vistaPrincipal;

  public static void inicialitzarPresentacio() {
    CtrlDominiInterficie.iniBD();
    vistaPrincipal = new VistaPrincipal();
    vistaPrincipal.ferVisible();
  }
  
  public static void guardarSolucio() {
      CtrlDominiInterficie.guardarSolucio();
  }
  
  public static void reordenacioBiblioteca() throws Exception{
        CtrlDominiInterficie.reordenacioBiblioteca();
  }
  
  //AREA
  
  private static int seleccionaArea(String nomA) throws Exception{
        int id = CtrlDominiInterficie.seleccionaAreaN(nomA);
        return id;
  }
  
  public static void afegirArea(String nomArea) throws Exception{
        if (CtrlDominiInterficie.existeixArea(nomArea)) {
            throw new Exception("novaAreaJaExisteix");
        }
        else CtrlDominiInterficie.afegirArea(nomArea);
  }
  
  public static void modificarNomArea(String nomAold, String nomAnew) throws Exception{
      int id = seleccionaArea(nomAold);
      CtrlDominiInterficie.modificarNomArea(id, nomAnew);
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllArees() {
      return CtrlDominiInterficie.seleccionaAllArees();
  }
  
  
  //SECCIO
  
  private static int seleccionaSeccio(String nomS) throws Exception{
        int id = CtrlDominiInterficie.seleccionaSeccioN(nomS);
        return id;
  }
  
  public static void afegirSeccio(String nomSeccio, String nomArea) throws Exception{
        if (CtrlDominiInterficie.existeixSeccio(nomSeccio)) {
            throw new Exception("novaSeccioJaExisteix");
        }
        else if (!CtrlDominiInterficie.existeixArea(nomArea)) {
            throw new Exception("AreadenovaSeccioNoExisteix");
        }
        else {
            int ida = seleccionaArea(nomArea);
            CtrlDominiInterficie.afegirSeccio(nomSeccio,ida);
        }
  }
  
  public static void modificarNomSeccio(String nomSold, String nomSnew) throws Exception{
      int id = seleccionaSeccio(nomSold);
      CtrlDominiInterficie.modificarNomSeccio(id, nomSnew);
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllSeccions() {
      return CtrlDominiInterficie.seleccionaAllSeccions();
  }
  
  //TEMATICA
  
  private static int seleccionaTematica(String nomT) throws Exception{
        int id = CtrlDominiInterficie.seleccionaTematicaN(nomT);
        return id;
  }
  
  public static void afegirTematica(String nomTematica) throws Exception{
        if (CtrlDominiInterficie.existeixTematica(nomTematica)) {
            throw new Exception("novaTematicaJaExisteix");
        }
        else CtrlDominiInterficie.afegirArea(nomTematica);
  }
  
  public static void modificarNomTematica(String nomTold, String nomTnew) throws Exception{
      int id = seleccionaTematica(nomTold);
      CtrlDominiInterficie.modificarNomTematica(id, nomTnew);
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllTematiques() {
      return CtrlDominiInterficie.seleccionaAllTematiques();
  }
  
  //LLIBRE
  
  private static int seleccionaLlibre(String titol, String autor, int any) throws Exception{
        int id = CtrlDominiInterficie.seleccionaLlibre(titol,autor,any);
        return id;
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllLlibres() {
      return CtrlDominiInterficie.seleccionaAllLlibres();
  }
  
  //ESTANTERIA
  
  private static int seleccionaEstanteria(int posX, int posY) throws Exception{
        int id = CtrlDominiInterficie.seleccionaEstanteria(posX,posY);
        return id;
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllEstanteries() {
      return CtrlDominiInterficie.seleccionaAllEstanteries();
  }
  
}
