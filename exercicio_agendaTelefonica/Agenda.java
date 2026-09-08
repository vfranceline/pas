package exercicio_agendaTelefonica;

import java.util.*;

public abstract class Agenda {

    public abstract boolean adicionaContato(IF_Contato contato);

    public abstract boolean removeContato(String telefone);

    public abstract IF_Contato getContato(String telefone);

    public abstract Collection getLista();

    public IF_Contato listaContato() {
        Iterator<IF_Contato> iterator = this.getLista().iterator();

        while (iterator.hasNext()) {
            IF_Contato contato = iterator.next();
            return contato;
        }
        return null;
    }

    public IF_Contato listaContatoIniciais(String iniciais) {
        Iterator<IF_Contato> iterator = this.getLista().iterator();

        while (iterator.hasNext()) {
            IF_Contato contato = iterator.next();
            if (contato.getNome().startsWith(iniciais)) {
                return contato;
            }
        }
        return null;
    }
}

class AgendaList extends Agenda {

    private ArrayList<IF_Contato> listaAgenda = new ArrayList<>();

    private int localizaContato(String telefone) {
        for (int index = 0; index < listaAgenda.size(); index++) {
            if (telefone.equals(listaAgenda.get(index).getTelefone())) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public IF_Contato getContato(String telefone) {
        int indice = localizaContato(telefone);
        if (indice < 0) {
            return null;
        }

        return this.listaAgenda.get(indice);
    }

    @Override
    public boolean adicionaContato(IF_Contato contato_) {
        if (localizaContato(contato_.getTelefone()) >= 0) {
                return false;
        }

        this.listaAgenda.add(contato_);
        return true;
    }

    @Override
    public boolean removeContato(String telefone) {
        int indice = localizaContato(telefone);

        if (indice < 0) {
            return false;
        } else {
            this.listaAgenda.remove(indice);
            return true;
        }
    }

    @Override
    public Collection<IF_Contato> getLista() {
        return this.listaAgenda;
    }

}

class AgendaMap extends Agenda {

    private HashMap<String, IF_Contato> listaContato = new HashMap<>();

    @Override
    public IF_Contato getContato(String telefone) {
        return listaContato.get(telefone);
    }

    @Override
    public boolean adicionaContato(IF_Contato contato) {
        boolean hasTelefone = listaContato.containsKey(contato.getTelefone());
        if (hasTelefone) {
            return false;
        }
        listaContato.put(contato.getTelefone(), contato);
        return true;
    }

    @Override
    public boolean removeContato(String telefone) {
        boolean hasContato = listaContato.containsKey(telefone);
        if (hasContato) {
            listaContato.remove(telefone);
            return true;
        }
        return false;
    }

    @Override
    public Collection<IF_Contato> getLista() {
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

}

class MainTesteFabrica {

    public static void main(String[] args) {
        Agenda agenda = FabricaAgenda.getInstancia().criaAgenda(FabricaAgenda.AGENDALIST);
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
