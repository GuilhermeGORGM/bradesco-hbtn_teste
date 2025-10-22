package src;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteEmail {

    @Test
    public void testar_email_com_arroba() {
        String email = "gui@teste.com.br";
        assertTrue(Pessoa.emailValid(email));
    }

    @Test
    public void testar_email_sem_arroba() {
        String email = "gui.com.br";
        assertFalse(Pessoa.emailValid(email));
    }

    @Test
    public void testar_email_mais_50_caracteres() {
        String email = "guiksdnfosnfosdnfodsnfjsnfjdsnfisnfijsnfijnsi@dominio.com.br";
        assertFalse(Pessoa.emailValid(email));
    }
}
