public abstract class Mensagem {
    private String email;
    protected String conteudo;
    private String dataHora;

    public Mensagem(String email, String conteudo, String dataHora) {
        this.email = email;
        this.conteudo = conteudo;
        this.dataHora = dataHora;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    // Passos abstratos do template method
    public abstract void verifica() throws Exception;
    public abstract String getTxtMensagem();

    // Template Method
    public String envia(Destinatario destinatario) throws Exception {
        verifica();
        return "Mensagem para " + destinatario.getNomeCompleto() + " " + getTxtMensagem();
    }
}

public class Main {
    public static void main(String args[]){
        Destinatario[] d = new Destinatario[2];
        
        d[0]= new Destinatario();
        d[0].setNome("emjorge");
        d[0].setNomeCompleto("Eduardo M. F. jorge");
        
        d[1]= new Destinatario();
        d[1].setNome("camila");
        d[1].setNomeCompleto("Camila S. P. Jorge");
        
        Mensagem email = new Email("emjorge@gmail.com","Prova Tópicos II","03/10/2005","Aviso");
        Mensagem email1 = new Email("emjorge@gmail.com","Prova Tópicos II","03/10/2005","");
        
        Mensagem sms = new Sms("camila@gmail.com","A Prova de Tópicos II será na sala 36","03/10/2005","9129-2234");
        Mensagem sms1 = new Sms("camila@gmail.com","Prova Tópicos II","03/10/2005","9129-2234");
        
        try{
            System.out.println(email.envia(d[0]));
        }catch(Exception e){ 
            System.out.println(e.getMessage()); 
        }
        
        try{
            System.out.println(email1.envia(d[1]));
        }catch(Exception e){ 
            System.out.println(e.getMessage()); 
        }
        
        try{
            System.out.println(sms.envia(d[0]));
        }catch(Exception e){ 
            System.out.println(e.getMessage()); 
        }
        
        try{
            System.out.println(sms1.envia(d[1]));
        }catch(Exception e){ 
            System.out.println(e.getMessage()); 
        }
    }
}
