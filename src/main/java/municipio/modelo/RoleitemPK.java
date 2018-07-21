package municipio.modelo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoleitemPK implements Serializable {
    private int idrole;
    private String item;

    @Column(name = "idrole", nullable = false)
    @Id
    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    @Column(name = "item", nullable = false, length = 255)
    @Id
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleitemPK that = (RoleitemPK) o;
        return idrole == that.idrole &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idrole, item);
    }
}
