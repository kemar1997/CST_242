<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PublisherTable.aspx.cs" Inherits="Books.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Publisher Table</title>
</head>
<body>
    <form id="form1" runat="server">
        <img src="Images/books_banner.jpg" />

    <div style="position:absolute; top:250px; left:200px;">
        <asp:SqlDataSource ID="SqlDataSourcePublisher" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringBooks %>" DeleteCommand="DELETE FROM [Publisher] WHERE [PublisherCode] = ?" InsertCommand="INSERT INTO [Publisher] ([PublisherCode], [Name], [City]) VALUES (?, ?, ?)" ProviderName="<%$ ConnectionStrings:ConnectionStringBooks.ProviderName %>" SelectCommand="SELECT [PublisherCode], [Name], [City] FROM [Publisher]" UpdateCommand="UPDATE [Publisher] SET [Name] = ?, [City] = ? WHERE [PublisherCode] = ?">
            <DeleteParameters>
                <asp:Parameter Name="PublisherCode" Type="String" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="PublisherCode" Type="String" />
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="City" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="City" Type="String" />
                <asp:Parameter Name="PublisherCode" Type="String" />
            </UpdateParameters>
        </asp:SqlDataSource>

        <asp:GridView ID="GridViewPublisher" runat="server" AutoGenerateColumns="False" DataKeyNames="PublisherCode" DataSourceID="SqlDataSourcePublisher" CellPadding="4" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:CommandField ShowEditButton="True" />
                <asp:BoundField DataField="PublisherCode" HeaderText="Publisher #" ReadOnly="True" SortExpression="PublisherCode" />
                <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
                <asp:BoundField DataField="City" HeaderText="City" SortExpression="City" />
            </Columns>
            <EditRowStyle BackColor="#2461BF" />
            <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#EFF3FB" />
            <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#F5F7FB" />
            <SortedAscendingHeaderStyle BackColor="#6D95E1" />
            <SortedDescendingCellStyle BackColor="#E9EBEF" />
            <SortedDescendingHeaderStyle BackColor="#4870BE" />
        </asp:GridView>

        <p>
            <asp:Button ID="ButtonPublisherInsert" runat="server" Text="Insert New Publisher" OnClick="ButtonPublisherInsert_Click" />

            <asp:Button ID="ButtonPublisherSearch" runat="server" Text="Search for Publisher" OnClick="ButtonPublisherSearch_Click" />
        </p>

    </div>
    </form>
    
</body>
</html>
