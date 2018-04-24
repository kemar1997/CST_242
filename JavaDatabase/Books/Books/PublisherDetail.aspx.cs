using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Books
{
    public partial class PublisherDetail : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Button Event Handler to open the Publisher Table web page
        protected void ButtonPublisherTable_Click(object sender, EventArgs e)
        {
            Response.Redirect("PublisherTable.aspx");
        }
    }
}