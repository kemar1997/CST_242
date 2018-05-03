using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project09_CST242
{
    public partial class BookTable : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Event Handler that redirects the user to the "BookInsert.aspx" webpage
        protected void ButtonInsert_Click(object sender, EventArgs e) => Response.Redirect("BookInsert.aspx");

        // Event Handler that redirects the user to the "BookSearch.aspx" webpage
        protected void ButtonSearch_Click(object sender, EventArgs e) => Response.Redirect("BookSearch.aspx");
    }
}