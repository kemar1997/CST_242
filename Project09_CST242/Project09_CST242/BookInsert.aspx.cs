using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project09_CST242
{
    public partial class BookInsert : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void ButtonInsertBook_Click(object sender, EventArgs e)
        {
            try
            {
                SqlDataSourceBook.InsertParameters["BookCode"].DefaultValue = TextBoxBookCode.Text;
                SqlDataSourceBook.InsertParameters["Title"].DefaultValue = TextBoxBookTitle.Text;
                SqlDataSourceBook.InsertParameters["PublisherCode"].DefaultValue = TextBoxPublisherCode.Text;
                SqlDataSourceBook.InsertParameters["Type"].DefaultValue = TextBoxBookType.Text;
                SqlDataSourceBook.InsertParameters["Price"].DefaultValue = TextBoxBookPrice.Text;

                // Insert Method
                SqlDataSourceBook.Insert();

                // Prove that Insert worked
                Response.Redirect("BookTable.aspx");
            }
            catch (Exception ex)
            {
                LabelErrorMessage.Text = ex.Message;
            }
        }

        protected void ButtonBookTable_Click(object sender, EventArgs e) => Response.Redirect("BookTable.aspx");
    }
}