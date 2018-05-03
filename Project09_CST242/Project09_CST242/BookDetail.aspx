<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BookDetail.aspx.cs" Inherits="Project09_CST242.BookDetail" %>

<!DOCTYPE html>
<!-- Kemar, Woonnie, Sophia -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Book Detail</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <img src="Images/books_banner.jpg" />
        </div>

        <div style="position:absolute; top:250px; left:200px;">
            <asp:SqlDataSource ID="SqlDataSourceBook" runat="server" ConnectionString="<%$ ConnectionStrings:BooksTable %>" ProviderName="<%$ ConnectionStrings:BooksTable.ProviderName %>" SelectCommand="SELECT [BookCode], [Title], [PublisherCode], [Type], [Price] FROM [Book] WHERE ([BookCode] = ?)">
                <SelectParameters>
                    <asp:QueryStringParameter Name="BookCode" QueryStringField="BookCode" Type="String" />
                </SelectParameters>
            </asp:SqlDataSource>

            <asp:DetailsView ID="DetailsViewBook" runat="server" Height="50px" Width="202px" AutoGenerateRows="False" CellPadding="4" DataKeyNames="BookCode" DataSourceID="SqlDataSourceBook" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" />
                <CommandRowStyle BackColor="#FFFFC0" Font-Bold="True" />
                <FieldHeaderStyle BackColor="#FFFF99" Font-Bold="True" />
                <Fields>
                    <asp:BoundField DataField="BookCode" HeaderText="BookCode" ReadOnly="True" SortExpression="BookCode" />
                    <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" />
                    <asp:BoundField DataField="PublisherCode" HeaderText="PublisherCode" SortExpression="PublisherCode" />
                    <asp:BoundField DataField="Type" HeaderText="Type" SortExpression="Type" />
                    <asp:BoundField DataField="Price" HeaderText="Price" SortExpression="Price" />
                </Fields>
                <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#FFCC66" ForeColor="#333333" HorizontalAlign="Center" />
                <RowStyle BackColor="#FFFBD6" ForeColor="#333333" />
            </asp:DetailsView>

            <p>
                <asp:Button ID="ButtonBookTable" runat="server" Text="Go To Book Table" OnClick="ButtonBookTable_Click" />
            </p>
        </div>
    </form>
</body>
</html>
