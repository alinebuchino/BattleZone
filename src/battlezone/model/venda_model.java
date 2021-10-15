package battlezone.model;


/**
 *
 * @author Aline Buchino
 */
public class venda_model {
    
    private String primaryKey;
    private String total;
    private String data;
    
    public venda_model(){
        
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
}
