package exercicio_agendaTelefonica;

import java.util.*;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;

public interface IF_Agenda {

    IF_Contato getContato(String telefone);

    boolean adicionaContato(IF_Contato contato);

    boolean removeContato(String telefone);

    Collection<IF_Contato> getListaAgenda();
}

class AgendaMap implements IF_Agenda {
    private Map<String, IF_Contato> listaContato = new HashMap<>();

    @Override
    public IF_Contato getContato(String telefone) {
        return listaContato.get(telefone);
    }

    @Override
    public boolean adicionaContato(IF_Contato contato) {
        boolean hasTelefone = listaContato.containsKey(contato.getTelefone());
        if (hasTelefone){
            return false;
        }
        listaContato.put(contato.getTelefone(), contato);
        return true;
    }

    @Override
    public boolean removeContato(String telefone) {
        boolean hasContato = listaContato.containsKey(telefone);
        if (hasContato){
            listaContato.remove(telefone);
            return true;
        }
        return false;
    }

    @Override
    public Collection<IF_Contato> getListaAgenda() {
        return listaContato.values();
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        Iterator<IF_Contato> valueIterator = this.listaContato.values().iterator();
        
        while (valueIterator.hasNext()) {
            IF_Contato value = valueIterator.next();
            texto.append("Nome: ").append(value.getNome()).append("\n");
            texto.append("Telefone: ").append(value.getTelefone()).append("\n\n");
        }
        
        return texto.toString();
    }

    public Collection<IF_Contato> listaContato() {
        return new ArrayList<>(listaContato.values());
    }

}

class MainTesteAgendaMap {

    public static void main(String[] args) {
        AgendaMap agenda = new AgendaMap();
        IF_Contato[] contatos = new IF_Contato[3];

        contatos[0] = new Contato();
        contatos[0].setNome("A");
        contatos[0].setTelefone("345-2455");
        System.out.println("Adicionando " + contatos[0]);
        agenda.adicionaContato(contatos[0]);

        contatos[1] = new Contato();
        contatos[1].setNome("X");
        contatos[1].setTelefone("234-9085");
        System.out.println("Adicionando " + contatos[1]);
        agenda.adicionaContato(contatos[1]);

        contatos[2] = new Contato();
        contatos[2].setNome("Y");
        contatos[2].setTelefone("8890-19085");
        System.out.println("Adicionando " + contatos[2]);
        agenda.adicionaContato(contatos[2]);

        System.out.println(agenda);
        System.out.println("Localizando 345-2455");
        System.out.println(agenda.getContato("345-2455"));
        System.out.println("Removendo 234-9085");
        agenda.removeContato("234-9085");
        System.out.println(agenda);
    }
}
