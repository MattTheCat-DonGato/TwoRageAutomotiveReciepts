package create;
import utilities.Invoice;

/**
 *
 * @author Matthew Rodriguez
 */
public class CreateModel
{
    //Invoice Model
    private Invoice invoice;

    /**
     * @return the invoice
     */
    public Invoice GetInvoice()
    {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void SetInvoice(Invoice invoice)
    {
        this.invoice = invoice;
    }
}