<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BookTable.aspx.cs" Inherits="Project09_CST242.BookTable" %>

<!DOCTYPE html>
<!-- Kemar, Woonnie, Sophia -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Book Table</title>
    <style type="text/css">
        .auto-style1 {
            width: 1004px;
            height: 195px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <img class="auto-style1" src="Images/books_banner.jpg" />
        </div>

        <div style="position: absolute; top: 250px; left: 200px; height: 243px; width: 409px;">

            <asp:SqlDataSource ID="SqlDataSourceBook" runat="server" ConnectionString="<%$ ConnectionStrings:BooksTable %>" ProviderName="<%$ ConnectionStrings:BooksTable.ProviderName %>" SelectCommand="SELECT [BookCode], [PublisherCode], [Title], [Type], [Price] FROM [Book]" DeleteCommand="DELETE FROM [Book] WHERE [BookCode] = ?" InsertCommand="INSERT INTO [Book] ([BookCode], [PublisherCode], [Title], [Type], [Price]) VALUES (?, ?, ?, ?, ?)" UpdateCommand="UPDATE [Book] SET [PublisherCode] = ?, [Title] = ?, [Type] = ?, [Price] = ? WHERE [BookCode] = ?">
                <DeleteParameters>
                    <asp:Parameter Name="BookCode" Type="String" />
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="BookCode" Type="String" />
                    <asp:Parameter Name="PublisherCode" Type="String" />
                    <asp:Parameter Name="Title" Type="String" />
                    <asp:Parameter Name="Type" Type="String" />
                    <asp:Parameter Name="Price" Type="Decimal" />
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="PublisherCode" Type="String" />
                    <asp:Parameter Name="Title" Type="String" />
                    <asp:Parameter Name="Type" Type="String" />
                    <asp:Parameter Name="Price" Type="Decimal" />
                    <asp:Parameter Name="BookCode" Type="String" />
                </UpdateParameters>
            </asp:SqlDataSource>
            <asp:GridView ID="GridViewBook" runat="server" AutoGenerateColumns="False" CellPadding="4" DataKeyNames="BookCode" DataSourceID="SqlDataSourceBook" ForeColor="#333333" GridLines="None" Width="263px">
                <AlternatingRowStyle BackColor="White" />
                <Columns>
                    <asp:CommandField ShowEditButton="True" />
                    <asp:BoundField DataField="BookCode" HeaderText="BookCode" ReadOnly="True" SortExpression="BookCode" />
                    <asp:BoundField DataField="PublisherCode" HeaderText="PublisherCode" SortExpression="PublisherCode" />
                    <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" />
                    <asp:BoundField DataField="Type" HeaderText="Type" SortExpression="Type" />
                    <asp:BoundField DataField="Price" HeaderText="Price" SortExpression="Price" />
                </Columns>
                <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#FFCC66" ForeColor="#333333" HorizontalAlign="Center" />
                <RowStyle BackColor="#FFFBD6" ForeColor="#333333" />
                <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="Navy" />
                <SortedAscendingCellStyle BackColor="#FDF5AC" />
                <SortedAscendingHeaderStyle BackColor="#4D0000" />
                <SortedDescendingCellStyle BackColor="#FCF6C0" />
                <SortedDescendingHeaderStyle BackColor="#820000" />
            </asp:GridView>

            <p>
                <asp:Button ID="ButtonInsert" runat="server" Text="Insert a New Book" OnClick="ButtonInsert_Click" />

                <asp:Button ID="ButtonSearch" runat="server" Text="Search For Book" OnClick="ButtonSearch_Click" />

            </p>


        </div>
    </form>
</body>
</html>
