package propLlibreria.Domini;
import propLlibreria.Persistencia.CtrlPersistencia;
import java.util.*;

public class CtrlDominiPersistencia {
    
    public static void omplirBD(){
        
        int ida = 0;
        int ids = 0;
        int idt = 0;
        int ide = 0;
        int idl = 0;
           
        // AREA           

        ArrayList<String[]> arees = CtrlPersistencia.obtenirTotesArees();
        for (int i=0; i<arees.size();i++){
            Area aux;
            String[] prop=arees.get(i);
            if(prop.length > 0 && !prop[0].equals("")){
                ArrayList<Integer> seccions = new ArrayList<Integer>();
                for (int j=2; j<prop.length; j++){
                        seccions.add(Integer.parseInt(prop[j]));
                }
                aux = new Area(Integer.parseInt(prop[0]),prop[1],seccions);
                GestioArea.afegirArea(aux);
                if(ida<Integer.parseInt(prop[0])){
                    ida=Integer.parseInt(prop[0]);
                }                   
            }
        }
        GestioArea.setIda(ida);

        // ESTANTERIA

        ArrayList<String[]> estant = CtrlPersistencia.obtenirTotesEstanteries();
        for (int i=0; i<estant.size();i++){
            Estanteria aux;
            String[] prop=estant.get(i);
            if(prop.length > 0 && !prop[0].equals("")){
                ArrayList<Integer> llibres = new ArrayList<Integer>();
                for (int j=5; j<prop.length; j++){
                        llibres.add(Integer.parseInt(prop[j]));
                }
                aux = new Estanteria(Integer.parseInt(prop[0]),Integer.parseInt(prop[1]),Integer.parseInt(prop[2]),Integer.parseInt(prop[3]),Integer.parseInt(prop[4]),llibres);
                GestioEstanteria.afegirEstanteria(aux);
                if(ide<Integer.parseInt(prop[0])){
                    ide=Integer.parseInt(prop[0]);
                }                    
            }
        }
        GestioEstanteria.setIde(ide);

        // LLIBRE

        ArrayList<String[]> llibres = CtrlPersistencia.obtenirTotsLlibres();
        for (int i=0; i<llibres.size();i++){
            Llibre aux;
            String[] prop=llibres.get(i);
            if(prop.length > 0 && !prop[0].equals("")){
                ArrayList<Integer> temSecun = new ArrayList<Integer>();
                for (int j=8; j<prop.length; j++){
                        temSecun.add(Integer.parseInt(prop[j]));
                }
                aux = new Llibre(Integer.parseInt(prop[0]),prop[1],prop[2],prop[3],prop[4],Integer.parseInt(prop[5]),Integer.parseInt(prop[6]),Integer.parseInt(prop[7]),temSecun);
                GestioLlibre.afegirLlibre(aux);
                if(idl<Integer.parseInt(prop[0])){
                    idl=Integer.parseInt(prop[0]);
                }                    
            }
        }
        GestioLlibre.setIdl(idl);        

        // SECCIO

        ArrayList<String[]> seccio = CtrlPersistencia.obtenirTotesSec();
        for (int i=0; i<seccio.size();i++){
            Seccio aux;
            String[] prop=seccio.get(i);
            if(prop.length > 0 && !prop[0].equals("")){
                ArrayList<Integer> tem = new ArrayList<Integer>();
                for (int j=3; j<prop.length; j++){
                        tem.add(Integer.parseInt(prop[j]));
                }
                aux = new Seccio(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]),tem);
                GestioArea.afegirSeccio(aux);
                if(ids<Integer.parseInt(prop[0])){
                    ids=Integer.parseInt(prop[0]);
                }                    
            }
        }
        GestioArea.setIds(ids);

        // TEMATICA

        ArrayList<String[]> tema = CtrlPersistencia.obtenirTotesTem();
        for (int i=0; i<tema.size();i++){
            Tematica aux;
            String[] prop=tema.get(i);
            if(prop.length > 0 && !prop[0].equals("")){
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (int j=3; j<prop.length; j++){
                        l.add(Integer.parseInt(prop[j]));
                }
                aux = new Tematica(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]),l);
                GestioArea.afegirTematica(aux);
                if(idt<Integer.parseInt(prop[0])){
                    idt=Integer.parseInt(prop[0]);
                }                    
            } 
        }
        GestioArea.setIdt(idt);
    }
	
    public static void desarBD(){

        // AREA            
        ArrayList<Area> area = GestioArea.getAllArees();
        ArrayList<String[]> a = new ArrayList<String[]>();
        for (int i=0; i<area.size(); i++){
            Area auxA = area.get(i);
            ArrayList<String> aux = new ArrayList<String>();
            aux.add(Integer.toString(auxA.getID()));
            aux.add(auxA.getNomArea());
            
            ArrayList<Seccio> seccioAux = auxA.getSeccions();
            for(int j=0; j<seccioAux.size();j++){
                        aux.add(Integer.toString(seccioAux.get(j).getID()));
            }
            String[] result= aux.toArray(new String[aux.size()]);               
            a.add(result);
        }
        CtrlPersistencia.desarTotesArees(a);

        // ESTANTERIA
        ArrayList<Estanteria> est = GestioEstanteria.getAllEstanteries();
        ArrayList<String[]> e = new ArrayList<String[]>();
        for (int i=0; i<est.size(); i++){
                Estanteria auxE=est.get(i);
                ArrayList<String> aux = new ArrayList<String>();
                aux.add(Integer.toString(auxE.getID()));
                aux.add(Integer.toString(auxE.getNumFiles()));
                aux.add(Integer.toString(auxE.getLlargada()));
                aux.add(Integer.toString(auxE.getPosX()));
                aux.add(Integer.toString(auxE.getPosY()));

                ArrayList<Llibre> llibreAux = auxE.getLlibres();
                for(int j=0; j<llibreAux.size();j++){
                        aux.add(Integer.toString(llibreAux.get(j).getID()));
                }
                String[] result= aux.toArray(new String[aux.size()]);
                e.add(result);
        }
        CtrlPersistencia.desarTotesEstanteries(e);

        // LLIBRE
        ArrayList<Llibre> llib = GestioLlibre.getAllLlibres();
        ArrayList<String[]> l = new ArrayList<String[]>();
        for (int i=0; i<llib.size(); i++){
                Llibre auxL=llib.get(i);			
                ArrayList<String> aux = new ArrayList<String>();
                aux.add(Integer.toString(auxL.getID()));
                aux.add(auxL.getIsbn());
                aux.add(auxL.getTitol());
                aux.add(auxL.getAutor());
                aux.add(auxL.getEditorial());
                aux.add(Integer.toString(auxL.getAny()));
                aux.add(Integer.toString(auxL.getEdicio()));
                Tematica t=GestioArea.getTematica(auxL.getTemPrincipal());
                aux.add(Integer.toString(t.getID()));

                ArrayList<Tematica> temAux = auxL.getTematiquesSecundaries();
                for(int j=0; j<temAux.size();j++){
                        aux.add(Integer.toString(temAux.get(j).getID()));
                }

                String[] result= aux.toArray(new String[aux.size()]);			
                l.add(result);
        }
        CtrlPersistencia.desarTotsLlibres(l);

        //SECCIO 
        ArrayList<Seccio> sec = GestioArea.getAllSeccions();
        ArrayList<String[]> s = new ArrayList<String[]>();
        for (int i=0; i<sec.size(); i++){
            Seccio auxS  = sec.get(i);
            ArrayList<String> aux = new ArrayList<String>();
            aux.add(Integer.toString(auxS.getID()));
            aux.add(auxS.getNomSeccio());
            aux.add(Integer.toString(auxS.getIDAreaSeccio()));

            ArrayList<Tematica> temAux = auxS.getTematiques();
            for(int j=0; j<temAux.size();j++){
                    aux.add(Integer.toString(temAux.get(j).getID()));
            }

            String[] result= aux.toArray(new String[aux.size()]);			
            l.add(result);
        }
        CtrlPersistencia.desarTotesSeccions(s);

        // TEMATICA
        ArrayList<Tematica> tem = GestioArea.getAllTematiques();
        ArrayList<String[]> t = new ArrayList<String[]>();
        for (int i=0; i<sec.size(); i++){
            Tematica auxT  = tem.get(i);
            ArrayList<String> aux = new ArrayList<String>();
            aux.add(Integer.toString(auxT.getID()));
            aux.add(auxT.getNomTematica());
            aux.add(Integer.toString(auxT.getIDSeccioTematica()));

            ArrayList<Llibre> temAux = auxT.getLlibres();
            for(int j=0; j<temAux.size();j++){
                    aux.add(Integer.toString(temAux.get(j).getID()));
            }			
            String[] result= aux.toArray(new String[aux.size()]);		
            t.add(result);
        }
        CtrlPersistencia.desarTotesTematiques(t);
    }	
}
