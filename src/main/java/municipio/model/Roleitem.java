package municipio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(RoleitemPK.class)
public class Roleitem {
    private int idrole;
    private String item;

    @Id
    @Column(name = "idrole", nullable = false)
    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    @Id
    @Column(name = "item", nullable = false, length = 255)
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
        Roleitem roleitem = (Roleitem) o;
        return idrole == roleitem.idrole &&
                Objects.equals(item, roleitem.item);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idrole, item);
    }
}
