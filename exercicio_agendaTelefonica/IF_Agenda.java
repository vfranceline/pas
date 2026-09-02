package exercicio_agendaTelefonica;

import java.util.*;

public interface IF_Agenda {

    IF_Contato getContato(String telefone);

    boolean adicionaContato(IF_Contato contato);

    boolean removeContato(String telefone);

    Collection<IF_Contato> getListaAgenda();
}

class AgendaList implements IF_Agenda {
    private List<IF_Contato> listaContato = new ArrayList<IF_Contato>();

    private int localizaContato(String telefone){
      IF_Contato contato = new Contato();
      contato.setTelefone(telefone);

      return this.listaContato.indexOf(contato);
    }

    @Override
    public IF_Contato getContato(String telefone){
      return this.listaContato.get(localizaContato(telefone));
    }

    @Override
    public boolean adicionaContato(IF_Contato contato_){
      int indice = localizaContato(contato_.getTelefone());
      if (listaContato.get(indice)){
        return false;
      } else {
        this.listaContato.add(contato_);
        return true;
      }
    }

    @Override
    public boolean removeContato(String telefone) {
      int indice = localizaContato(telefone);

      if (indice < 0){
        return false;
      } else {
        this.listaContato.remove(indice);
        return true;
      }
    }

    @Override
    public Collection<IF_Contato> getListaAgenda() {
        return this.listaContato;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        Iterator<IF_Contato> iterator = this.listaContato.iterator();
        
        while (iterator.hasNext()) {
            IF_Contato contato = iterator.next();
            int index = this.listaContato.indexOf(contato);
            
            texto.append("Posição ").append(index).append("\n");
            texto.append("Nome: ").append(contato.getNome()).append("\n");
            texto.append("Telefone: ").append(contato.getTelefone()).append("\n\n");
        }
        
        return texto.toString();
    }
}

class MainTesteAgendaList {

    public static void main(String[] args) {
        AgendaList agenda = new AgendaList();
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
