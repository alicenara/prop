package propLlibreria.Domini;
import propLlibreria.Persistencia.CtrlPersistencia;
import java.util.*;

public class CtrlDominiPersistencia {
    
        private static HashMap<Integer, Area> area = new HashMap<Integer, Area>();
        private static HashMap<Integer, Seccio> sec = new HashMap<Integer, Seccio>();
        private static HashMap<Integer, Tematica> tem = new HashMap<Integer, Tematica>();
        private static HashMap<Integer, Estanteria> est = new HashMap<Integer, Estanteria>();
        private static HashMap<Integer, Llibre> llibre = new HashMap<Integer, Llibre>();
        private static int ida = 0;
        private static int ids = 0;
        private static int idt = 0;
        private static int ide = 0;
        private static int idl = 0;
        
    public static void omplirBD(){         
           
        // AREA           

        ArrayList<String[]> arees = CtrlPersistencia.obtenirTotesArees();

        for (int i=0; i<arees.size();i++){
            Area aux;
            String[] prop=arees.get(i);
            if(!prop.equals("")){
                aux = new Area(Integer.parseInt(prop[0]),prop[1]);
                area.put(aux.getID(),aux);
                if(ida<Integer.parseInt(prop[0])){
                    ida=Integer.parseInt(prop[0]);
                }                   
            }
        }
        GestioArea.setHashArea(area, ida);

        // ESTANTERIA

        ArrayList<String[]> estant = CtrlPersistencia.obtenirTotesEstanteries();
        estant = CtrlPersistencia.obtenirTotesEstanteries();
        for (int i=0; i<estant.size();i++){
            Estanteria aux;
            String[] prop=estant.get(i);
            if(!prop.equals("")){
                ArrayList<Integer> llibres = new ArrayList<Integer>();
                for (int j=5; j<prop.length; j++){
                        llibres.add(Integer.parseInt(prop[j]));
                }
                aux = new Estanteria(Integer.parseInt(prop[0]),Integer.parseInt(prop[1]),Integer.parseInt(prop[2]),Integer.parseInt(prop[3]),Integer.parseInt(prop[4]),llibres);
                est.put(aux.getID(),aux);
                if(ide<Integer.parseInt(prop[0])){
                    ide=Integer.parseInt(prop[0]);
                }                    
            }
        }
        GestioEstanteria.setHashEstanteria(est,ide);

        // LLIBRE

        ArrayList<String[]> llibres = CtrlPersistencia.obtenirTotsLlibres();
        for (int i=0; i<llibres.size();i++){
            Llibre aux;
            String[] prop=llibres.get(i);
            if(!prop.equals("")){
                ArrayList<Integer> temSecun = new ArrayList<Integer>();
                for (int j=8; j<prop.length; j++){
                        temSecun.add(Integer.parseInt(prop[j]));
                }
                aux = new Llibre(Integer.parseInt(prop[0]),prop[1],prop[2],prop[3],prop[4],Integer.parseInt(prop[5]),Integer.parseInt(prop[6]),Integer.parseInt(prop[7]),temSecun);
                llibre.put(aux.getID(),aux);
                if(idl<Integer.parseInt(prop[0])){
                    idl=Integer.parseInt(prop[0]);
                }                    
            }
        }
        GestioLlibre.setHashLlibre(llibre,idl);        

        // SECCIO

        ArrayList<String[]> seccio = CtrlPersistencia.obtenirTotesSec();
        for (int i=0; i<seccio.size();i++){
            Seccio aux;
            String[] prop=seccio.get(i);
            if(!prop.equals("")){
                aux = new Seccio(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]));
                sec.put(aux.getID(),aux);
                if(ids<Integer.parseInt(prop[0])){
                    ids=Integer.parseInt(prop[0]);
                }                    
            }
        }
        GestioArea.setHashSeccio(sec, ids);

        // TEMATICA

        ArrayList<String[]> tema = CtrlPersistencia.obtenirTotesTem();
        for (int i=0; i<tema.size();i++){
            Tematica aux;
            String[] prop=tema.get(i);
            if(!prop.equals("")){
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (int j=3; j<prop.length; j++){
                        l.add(Integer.parseInt(prop[j]));
                }
                aux = new Tematica(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]),l);
                tem.put(aux.getID(),aux);
                if(idt<Integer.parseInt(prop[0])){
                    idt=Integer.parseInt(prop[0]);
                }                    
            } 
        }
        GestioArea.setHashTematica(tem, idt);
    }
	
    public static void desarBD(){

        //Primer cal omplir els hashMaps
        area = GestioArea.getHashArea();
        sec = GestioArea.getHashSeccio();
        tem = GestioArea.getHashTematica();
        est = GestioEstanteria.getHashEstanteria();
        llibre = GestioLlibre.getHashLlibre();            

        // AREA            
        Iterator<Integer> ia = area.keySet().iterator();
        Integer key = 0;
        ArrayList<String[]> a = new ArrayList<String[]>();
        while(ia.hasNext()){
            key = ia.next();
            String[] aux = {Integer.toString(area.get(key).getID()),area.get(key).getNomArea()};
            a.add(aux);
        }
        CtrlPersistencia.desarTotesArees(a);

        // ESTANTERIA
        Iterator<Integer> ic = est.keySet().iterator();
        key = 0;
        ArrayList<String[]> e = new ArrayList<String[]>();
        while(ic.hasNext()){
                key = ic.next();
                ArrayList<String> aux = new ArrayList<String>();
                aux.add(Integer.toString(est.get(key).getID()));
                aux.add(Integer.toString(est.get(key).getNumFiles()));
                aux.add(Integer.toString(est.get(key).getLlargada()));
                aux.add(Integer.toString(est.get(key).getPosX()));
                aux.add(Integer.toString(est.get(key).getPosY()));

                ArrayList<Llibre> llibreAux = est.get(key).getLlibres();
                for(int j=0; j<llibreAux.size();j++){
                        aux.add(Integer.toString(llibreAux.get(j).getID()));
                }
                String[] result= aux.toArray(new String[aux.size()]);
                e.add(result);
        }
        CtrlPersistencia.desarTotesEstanteries(e);

        // LLIBRE
        Iterator<Integer> id = llibre.keySet().iterator();
        key = 0;
        ArrayList<String[]> l = new ArrayList<String[]>();
        while(id.hasNext()){
                key = id.next();			
                ArrayList<String> aux = new ArrayList<String>();
                aux.add(Integer.toString(llibre.get(key).getID()));
                aux.add(llibre.get(key).getIsbn());
                aux.add(llibre.get(key).getTitol());
                aux.add(llibre.get(key).getAutor());
                aux.add(llibre.get(key).getEditorial());
                aux.add(Integer.toString(llibre.get(key).getAny()));
                aux.add(Integer.toString(llibre.get(key).getEdicio()));
                Tematica t=llibre.get(key).getTemPrincipal();
                aux.add(Integer.toString(t.getID()));

                ArrayList<Tematica> temAux = llibre.get(key).getTematiquesSecundaries();
                for(int j=0; j<temAux.size();j++){
                        aux.add(Integer.toString(temAux.get(j).getID()));
                }

                String[] result= aux.toArray(new String[aux.size()]);			
                l.add(result);
        }
        CtrlPersistencia.desarTotsLlibres(l);

        //SECCIO 
        Iterator<Integer> ie = sec.keySet().iterator();
        key = 0;
        ArrayList<String[]> s = new ArrayList<String[]>();
        while(ie.hasNext()){
                key = ie.next();
                String[] aux = {Integer.toString(sec.get(key).getID()),sec.get(key).getNomSeccio(),Integer.toString(sec.get(key).getIDAreaSeccio())};
                s.add(aux);
        }
        CtrlPersistencia.desarTotesSeccions(s);

        // TEMATICA
        Iterator<Integer> it = tem.keySet().iterator();
        key = 0;
        ArrayList<String[]> t = new ArrayList<String[]>();
        while(it.hasNext()){
                key = it.next();			
                ArrayList<String> aux = new ArrayList<String>();
                aux.add(Integer.toString(tem.get(key).getID()));
                aux.add(tem.get(key).getNomTematica());
                aux.add(Integer.toString(tem.get(key).getIDSeccio()));

                ArrayList<Llibre> temAux = tem.get(key).getLlibres();
                for(int j=0; j<temAux.size();j++){
                        aux.add(Integer.toString(temAux.get(j).getID()));
                }			
                String[] result= aux.toArray(new String[aux.size()]);		
                t.add(result);
        }
        CtrlPersistencia.desarTotesTematiques(t);
    }
	
}
