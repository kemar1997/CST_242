using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Books
{
    public partial class PublisherSearch : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Button Event Handler to open the Publisher Detail web page
        // and pass a PublisherCode query string value from the DropDownList
        protected void ButtonPublisherSearch_Click(object sender, EventArgs e)
        {
            Response.Redirect("PublisherDetail.aspx?PublisherCode="
                + DropDownListPublisher.SelectedValue);
        }
    }
}