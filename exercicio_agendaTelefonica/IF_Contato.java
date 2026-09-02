package exercicio_agendaTelefonica;

public interface IF_Contato {

    String getNome();
    String getTelefone();

    void setNome(String nome);
    void setTelefone(String telefone);
}

class Contato implements IF_Contato {
    private String nome;
    private String telefone;

    public Contato() {
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public void setNome(String nome_) {
        this.nome = nome_;
    }

    @Override
    public void setTelefone(String telefone_) {
        this.telefone = telefone_;
    }

    @Override
    public boolean equals(Object o){
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Contato outro = (Contato)o;
      return this.telefone.equals(outro.telefone);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nTelefone: " + this.telefone;
    }
}

class MainTesteContato {

    public static void main(String[] args) {
        IF_Contato c = new Contato();
        c.setNome("Eduardo");
        c.setTelefone("71999999999");
        System.out.println(c);
    }
}
