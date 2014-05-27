
package propLlibreria.Interficie;
import propLlibreria.Domini.CtrlDominiInterficie;

/**
 *
 * @author towerthousand
 */
public final class CtrlInterficie {
    private final VistaPrincipal vistaPrincipal;

  public CtrlInterficie() {
    vistaPrincipal = new VistaPrincipal();
    inicialitzarPresentacio();
  }

  public void inicialitzarPresentacio() {
    CtrlDominiInterficie.iniBD();
    vistaPrincipal.ferVisible();
  }
}
