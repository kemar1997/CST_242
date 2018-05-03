using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project09_CST242
{
    public partial class BookSearch : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ButtonSearchBook_Click(object sender, EventArgs e)
        {
            Response.Redirect("BookDetail.aspx?BookCode="
                + DropDownListBook.SelectedValue);
        }
    }
}