/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Domini;

import propLlibreria.Persistencia.GestioPersistencia;
import java.util.*;

/**
 *
 * @author sergibdn94
 */
public class CtrlDominiPersistencia {
    public static void omplirBD(){
           
            // AREA           
                
		ArrayList<String[]> arees = GestioPersistencia.obtenirTotesArees();
		for (int i=0; i<arees.size();i++){
			Area aux;
			String[] prop=arees.get(i);
                        if(!prop.equals("")){
                            aux = new Area(Integer.parseInt(prop[0]),prop[1]);
                            area.put(aux.getID(),aux);
                            if(ida<Integer.parseInt(prop[0]))
                                ida=Integer.parseInt(prop[0]);
                        }
		}	
	
            // BIBLIOTECARI
                
                ArrayList<String[]> persones = GestioPersistencia.obtenirTotsBcaris();
                for (int i=0; i<persones.size();i++){
			Bibliotecari aux;
			String[] prop=persones.get(i);
                        if(!prop.equals("")){
                            aux = new Bibliotecari(Integer.parseInt(prop[0]), prop[1]);
                            bcari.put(aux.getID(),aux);
                            if(idb<Integer.parseInt(prop[0]))
                                idb=Integer.parseInt(prop[0]);
                        }
		}
            
            // ESTANTERIA
                
                ArrayList<String[]> estant = GestioPersistencia.obtenirTotesEstanteries();
		estant = GestioPersistencia.obtenirTotesEstanteries();
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
                            if(ide<Integer.parseInt(prop[0]))
                                ide=Integer.parseInt(prop[0]);
                        }
		}
                
            // LLIBRE
                
                ArrayList<String[]> llibres = GestioPersistencia.obtenirTotsLlibres();
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
                            if(idl<Integer.parseInt(prop[0]))
                                idl=Integer.parseInt(prop[0]);
                        }
                }
                
            // SECCIO
                
                ArrayList<String[]> seccio = GestioPersistencia.obtenirTotesSec();
                for (int i=0; i<seccio.size();i++){
			Seccio aux;
			String[] prop=seccio.get(i);
                        if(!prop.equals("")){
                            aux = new Seccio(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]));
                            sec.put(aux.getID(),aux);
                            if(ids<Integer.parseInt(prop[0]))
                                ids=Integer.parseInt(prop[0]);
                        }
		}
                
            // TEMATICA
                
                ArrayList<String[]> tema = GestioPersistencia.obtenirTotesTem();
                for (int i=0; i<tema.size();i++){
			Tematica aux;
			String[] prop=tema.get(i);
                        if(!prop.equals("")){
                            ArrayList<Integer> llib = new ArrayList<Integer>();
                            for (int j=3; j<prop.length; j++){
                                    llib.add(Integer.parseInt(prop[j]));
                            }
                            aux = new Tematica(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]),llib);
                            tem.put(aux.getID(),aux);
                            if(idt<Integer.parseInt(prop[0]))
                                idt=Integer.parseInt(prop[0]);
                        }
			
		}
        }
	
	public static void desarBD(){
            
            // AREA            
                Iterator<Integer> ia = area.keySet().iterator();
		Integer key = 0;
		ArrayList<String[]> a = new ArrayList<String[]>();
		while(ia.hasNext()){
                    key = ia.next();
                    String[] aux = {Integer.toString(area.get(key).getID()),area.get(key).getNomArea()};
                    a.add(aux);
		}
                GestioPersistencia.desarTotesArees(a);
                
            // BIBLIOTECARI
                Iterator<Integer> ib = bcari.keySet().iterator();
		key = 0;
                ArrayList<String[]> b = new ArrayList<String[]>();
		while(ib.hasNext()){
                    key = ib.next();
                    String[] aux = {Integer.toString(bcari.get(key).getID()),bcari.get(key).getContrasenya()};
                    b.add(aux);
		}                
		GestioPersistencia.desarTotsBibliotecaris(b);
                
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
		GestioPersistencia.desarTotesEstanteries(e);
                
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
		GestioPersistencia.desarTotsLlibres(l);
                
            //SECCIO 
                Iterator<Integer> ie = sec.keySet().iterator();
		key = 0;
                ArrayList<String[]> s = new ArrayList<String[]>();
		while(ie.hasNext()){
                        key = ie.next();
			String[] aux = {Integer.toString(sec.get(key).getID()),sec.get(key).getNomSeccio(),Integer.toString(sec.get(key).getIDAreaSeccio())};
			s.add(aux);
		}
		GestioPersistencia.desarTotesSeccions(s);
                
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
		GestioPersistencia.desarTotesTematiques(t);
	}
	
}
