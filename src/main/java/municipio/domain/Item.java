package municipio.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Item {
    private String item;
    private String descricao;

    @Id
    @Column(name = "item", nullable = false, length = 255)
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "descricao", nullable = true, length = 255)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item1 = (Item) o;
        return Objects.equals(item, item1.item) &&
                Objects.equals(descricao, item1.descricao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(item, descricao);
    }
}
