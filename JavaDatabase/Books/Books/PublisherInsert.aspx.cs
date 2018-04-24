using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Books
{
    public partial class PublisherInsert : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Manually inserts a new Publisher record from Text property values in the TextBoxes
        protected void ButtonInsertPublisher_Click(object sender, EventArgs e)
        {
            try {
                SqlDataSourcePublisher.InsertParameters["PublisherCode"].DefaultValue = TextBoxPublisherCode.Text;
                SqlDataSourcePublisher.InsertParameters["Name"].DefaultValue = TextBoxName.Text;
                SqlDataSourcePublisher.InsertParameters["City"].DefaultValue = TextBoxCity.Text;

                // Insert Method
                SqlDataSourcePublisher.Insert();

                // Prove that Insert worked
                Response.Redirect("PublisherTable.aspx");
            } catch (Exception ex) {
                LabelErrorMessage.Text = ex.Message;
            }
        }

        // Button Event Handler to open the PublisherTable webpage
        protected void ButtonPublisherTable_Click(object sender, EventArgs e)
        {
            Response.Redirect("PublisherTable.aspx");
        }
    }
}