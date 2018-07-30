package municipio.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.ArrayList;
import java.util.List;


public class AddClientController extends SelectorComposer<Component> {


    @Wire("#grpData")
    Div grpData, grpOtherData;

    @Wire
    Include idInclData, idInclOtherData;

    @Wire
    private Combobox cmbLegalentitytype;

    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);
    }


    public ListModel<String> getEntidadeLegalModel() {
        List<String> entidadeLegal = new ArrayList<String>();

        // Get data from Database
        entidadeLegal.add("Pessoa Singular");
        entidadeLegal.add("Organização");

        return new ListModelList<String>(entidadeLegal);
    }

    @Listen("onChange = combobox#cmbLegalentitytype")
    public void change() {
       String str = cmbLegalentitytype.getSelectedItem().getValue();
        if(str.equals("Pessoa Singular")) {
            grpData.setVisible(true);
            idInclData.setSrc("conta/clientdata.zul");
        }else if(str.equals("Organização")){
            grpData.setVisible(true);
            idInclData.setSrc("conta/orgdata.zul");
        }
    }



}
