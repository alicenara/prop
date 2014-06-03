
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
  
  public static void reordenacioBiblioteca(boolean heuristic) throws Exception{
        CtrlDominiInterficie.reordenacioBiblioteca(heuristic);
  }
  
  //AREA
  
  private static int seleccionaArea(String nomA) throws Exception{
        int id = CtrlDominiInterficie.seleccionaAreaN(nomA);
        return id;
  }
  
  public static void crearArea(String nomArea) throws Exception{
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
      if (CtrlDominiInterficie.conteAreaSeccio(ida,ids)) throw new Exception("areaJaConteSeccio");
      CtrlDominiInterficie.afegirSeccioArea(ida, ids);
  }
  
  public static void eliminarArea(String nomA) throws Exception{
      int ida = seleccionaArea(nomA);
      CtrlDominiInterficie.esborrarArea(ida);
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
  
  public static void crearSeccio(String nomSeccio, String nomArea) throws Exception{
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
      if (CtrlDominiInterficie.conteSeccioTematica(ids,idt)) throw new Exception("seccioJaConteTematica");
      CtrlDominiInterficie.afegirTematicaSeccio(ids, idt);
  }
  
  public static void eliminarSeccio(String nomS) throws Exception{
      int ids = seleccionaSeccio(nomS);
      CtrlDominiInterficie.esborrarSeccio(ids);
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
  
  public static void crearTematica(String nomTematica, String nomSeccio) throws Exception{
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
  
  public static void afegirLlibreTematica(String nomT, String titol, String autor, int any) throws Exception{
      int idt = seleccionaTematica(nomT);
      int idl = seleccionaLlibre(titol,autor,any);
      if (CtrlDominiInterficie.conteTematicaLlibre(idt,idl)) throw new Exception("tematicaJaConteLlibre");
      CtrlDominiInterficie.afegirLlibreTematica(idt, idl);
  }
  
  public static void eliminarTematica(String nomT) throws Exception{
      int idt = seleccionaTematica(nomT);
      CtrlDominiInterficie.esborrarTematica(idt);
  }
  
  public static ArrayList<ArrayList<String> > consultarLlibresTematica(String nomT) throws Exception {
      int idt = seleccionaTematica(nomT);
      return CtrlDominiInterficie.consultarLlibresTematica(idt);
  }
  
  public static ArrayList<ArrayList<String> > seleccionaAllTematiques() {
      return CtrlDominiInterficie.seleccionaAllTematiques();
  }
  
  //LLIBRE
  
  private static int seleccionaLlibre(String titol, String autor, int any) throws Exception{
        int id = CtrlDominiInterficie.seleccionaLlibre(titol,autor,any);
        return id;
  }
  
  public static void crearLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, String nomTp) throws Exception{
      if (CtrlDominiInterficie.existeixLlibre(titol,autor,any)) {
            throw new Exception("nouLlibreJaExisteix");
        }
        else {
            int idtp = seleccionaTematica(nomTp);
            CtrlDominiInterficie.afegirLlibre(isbn,titol,autor,editorial,any,edicio,idtp);
        }
  }
  
  public static void modificarIsbnLlibre(String titol, String autor, int any, String modIsbn) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.modificarIsbnLlibre(idl,modIsbn);
  }
  
  public static void modificarTitolLlibre(String titol, String autor, int any, String modTitol) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.modificarTitolLlibre(idl,modTitol);
  }
  
  public static void modificarAutorLlibre(String titol, String autor, int any, String modAutor) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.modificarAutorLlibre(idl,modAutor);
  }
  
  public static void modificarEditorialLlibre(String titol, String autor, int any, String modEditorial) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.modificarEditorialLlibre(idl,modEditorial);
  }
  
  public static void modificarAnyLlibre(String titol, String autor, int any, int modAny) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.modificarAnyLlibre(idl,modAny);
  }
  
  public static void modificarEdicioLlibre(String titol, String autor, int any, int modEdicio) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.modificarEdicioLlibre(idl,modEdicio);
  }
  
  public static void modificarTPrincipalLlibre(String titol, String autor, int any, String nomT) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      int idt = seleccionaTematica(nomT);
      CtrlDominiInterficie.modificarEdicioLlibre(idl,idt);
  }
  
  public static void afegirTSecundaria(String titol, String autor, int any, String nomTs) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      int idt = seleccionaTematica(nomTs);
      if (CtrlDominiInterficie.conteLlibreTS(idl,idt)) throw new Exception("llibreJaConteTematicaS");
      CtrlDominiInterficie.afegirTSecundaria(idl, idt);
  }
  
  public static void esborrarTSecundaria(String titol, String autor, int any, String nomTs) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      int idt = seleccionaTematica(nomTs);
      if (!CtrlDominiInterficie.conteLlibreTS(idl,idt)) throw new Exception("llibreNoConteTematicaS");
      CtrlDominiInterficie.esborrarTSecundaria(idl, idt);
  }
  
  public static void eliminarLlibre(String titol, String autor, int any) throws Exception{
      int idl = seleccionaLlibre(titol,autor,any);
      CtrlDominiInterficie.esborrarLlibre(idl);
  }
  
  public static ArrayList<ArrayList<String> > consultaLlibresTitol(String titol) {
      return CtrlDominiInterficie.consultaLlibresTitol(titol);
  }
  
  public static ArrayList<ArrayList<String> > consultaLlibresPerISBN(String isbn) {
      return CtrlDominiInterficie.consultaLlibresPerISBN(isbn);
  }
  
  public static ArrayList<ArrayList<String> > consultaLlibresAutor(String autor) {
      return CtrlDominiInterficie.consultaLlibresAutor(autor);
  }
  
  public static ArrayList<ArrayList<String> > consultaLlibresAny(int any) {
      return CtrlDominiInterficie.consultaLlibresAny(any);
  }
  
  public static ArrayList<ArrayList<String> > consultaLlibresEditorial(String editorial) {
      return CtrlDominiInterficie.consultaLlibresEditorial(editorial);
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
