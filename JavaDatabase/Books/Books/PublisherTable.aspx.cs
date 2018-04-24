using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Books
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Button Event Handler to open the PublisherInsert webpage
        protected void ButtonPublisherInsert_Click(object sender, EventArgs e)
        {
            Response.Redirect("PublisherInsert.aspx");
        }

        // Button Event Handler to open the PublisherSearch webpage
        protected void ButtonPublisherSearch_Click(object sender, EventArgs e)
        {
            Response.Redirect("PublisherSearch.aspx");
        }
    }
}