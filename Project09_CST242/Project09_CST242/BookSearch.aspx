<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BookSearch.aspx.cs" Inherits="Project09_CST242.BookSearch" %>

<!DOCTYPE html>
<!-- Kemar, Woonnie, Sophia -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Book Search</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <img src="Images/books_banner.jpg" />
        </div>

        <div style="position:absolute; top:225px; left:200px;">
            <asp:SqlDataSource ID="SqlDataSourceBook" runat="server" ConnectionString="<%$ ConnectionStrings:BooksTable %>" ProviderName="<%$ ConnectionStrings:BooksTable.ProviderName %>" SelectCommand="SELECT [Title], [BookCode] FROM [Book]"></asp:SqlDataSource>

            <asp:DropDownList ID="DropDownListBook" runat="server" DataSourceID="SqlDataSourceBook" DataTextField="Title" DataValueField="BookCode"></asp:DropDownList>

            <p>
                <asp:Button ID="ButtonSearchBook" runat="server" Text="Search for Book" OnClick="ButtonSearchBook_Click" />
            </p>
        </div>
    </form>
</body>
</html>
