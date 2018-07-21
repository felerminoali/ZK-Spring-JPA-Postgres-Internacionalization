package municipio.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    private String utilizador;
    private String senha;

    @Id
    @Column(name = "utilizador", nullable = false, length = 255)
    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    @Basic
    @Column(name = "senha", nullable = true, length = 255)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(utilizador, user.utilizador) &&
                Objects.equals(senha, user.senha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(utilizador, senha);
    }
}
