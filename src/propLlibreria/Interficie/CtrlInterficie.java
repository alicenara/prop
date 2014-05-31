
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
      if (CtrlDominiInterficie.existeixArea(nomAnew)) {
            throw new Exception("nouNomAreaJaExisteix");
      }
      CtrlDominiInterficie.modificarNomArea(id, nomAnew);
  }
  
  public static void afegirSeccioArea(String nomA, String nomS) throws Exception{
      int ida = seleccionaArea(nomA);
      int ids = seleccionaSeccio(nomS);
      //TODO area no conte la seccio
      CtrlDominiInterficie.afegirSeccioArea(ida, ids);
  }
  
  public static void eliminarSeccioArea(String nomA, String nomS) throws Exception{
      int ida = seleccionaArea(nomA);
      int ids = seleccionaSeccio(nomS);
      //TODO area conte la seccio
      CtrlDominiInterficie.eliminarSeccioArea(ida, ids);
  }
  
  public static void eliminarArea(String nomA) throws Exception{
      int ida = seleccionaArea(nomA);
      CtrlDominiInterficie.eliminarArea(ida);
  }
  
  public static ArrayList<ArrayList<String> > consultarSeccionsArea(String nomA) throws Exception {
      int ida = seleccionaArea(nomA);
      return CtrlDominiInterficie.consultarSeccionsArea(ida);
  }
  
  public static ArrayList<ArrayList<String> > consultarTematiquesArea(String nomA) throws Exception {
      int ida = seleccionaArea(nomA);
      return CtrlDominiInterficie.consultarTematiquesArea(ida);
  }
  
  public static ArrayList<ArrayList<String> > consultarLlibresArea(String nomA) throws Exception {
      int ida = seleccionaArea(nomA);
      return CtrlDominiInterficie.consultarLlibresArea(ida);
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
        else {
            int ida = seleccionaArea(nomArea);
            CtrlDominiInterficie.afegirSeccio(nomSeccio,ida);
        }
  }
  
  public static void modificarNomSeccio(String nomSold, String nomSnew) throws Exception{
      int id = seleccionaSeccio(nomSold);
      if (CtrlDominiInterficie.existeixSeccio(nomSnew)) {
            throw new Exception("nouNomSeccioJaExisteix");
      }
      CtrlDominiInterficie.modificarNomSeccio(id, nomSnew);
  }
  
  public static void afegirTematicaSeccio(String nomS, String nomT) throws Exception{
      int ids = seleccionaSeccio(nomS);
      int idt = seleccionaTematica(nomT);
      //TODO EXC seccio no conte la tematica
      CtrlDominiInterficie.afegirSeccioArea(ids, idt);
  }
  
  public static void eliminarTematicaSeccio(String nomS, String nomT) throws Exception{
      int ids = seleccionaSeccio(nomS);
      int idt = seleccionaTematica(nomT);
      //TODO EXC seccio conte la tematica
      CtrlDominiInterficie.eliminarSeccioArea(ids, idt);
  }
  
  public static void eliminarSeccio(String nomS) throws Exception {
      int ids = seleccionaSeccio(nomS);
      CtrlDominiInterficie.eliminarSeccio(ids);
  }
  
  public static ArrayList<ArrayList<String> > consultarTematiquesSeccio(String nomS) throws Exception {
      int ids = seleccionaSeccio(nomS);
      return CtrlDominiInterficie.consultarTematiquesSeccio(ids);
  }
  
  public static ArrayList<ArrayList<String> > consultarLlibresSeccio(String nomS) throws Exception {
      int ids = seleccionaSeccio(nomS);
      return CtrlDominiInterficie.consultarLlibresSeccio(ids);
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllSeccions() {
      return CtrlDominiInterficie.seleccionaAllSeccions();
  }
  
  //TEMATICA
  
  private static int seleccionaTematica(String nomT) throws Exception{
        int id = CtrlDominiInterficie.seleccionaTematicaN(nomT);
        return id;
  }
  
  public static void afegirTematica(String nomTematica, String nomSeccio) throws Exception{
        if (CtrlDominiInterficie.existeixTematica(nomTematica)) {
            throw new Exception("novaTematicaJaExisteix");
        }
        else {
            int ids = seleccionaSeccio(nomSeccio);
            CtrlDominiInterficie.afegirTematica(nomTematica,ids);
        }
  }
  
  public static void modificarNomTematica(String nomTold, String nomTnew) throws Exception{
      int id = seleccionaTematica(nomTold);
      if (CtrlDominiInterficie.existeixTematica(nomTnew)) {
            throw new Exception("nouNomTematicaJaExisteix");
      }
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
