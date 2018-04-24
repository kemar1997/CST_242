<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PublisherSearch.aspx.cs" Inherits="Books.PublisherSearch" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head runat="server">
    <title>Publisher Search</title>
</head>

<body>
    <form id="form1" runat="server">
        <img src="Images/books_banner.jpg" />

        <div style="position:absolute; top:225px; left:200px;">

            <asp:SqlDataSource ID="SqlDataSourcePublisher" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringBooks %>" ProviderName="<%$ ConnectionStrings:ConnectionStringBooks.ProviderName %>" SelectCommand="SELECT [PublisherCode], [Name] FROM [Publisher]"></asp:SqlDataSource>

            <asp:DropDownList ID="DropDownListPublisher" runat="server" DataSourceID="SqlDataSourcePublisher" DataTextField="Name" DataValueField="PublisherCode"></asp:DropDownList>

            <p>
                <asp:Button ID="ButtonPublisherSearch" runat="server" Text="Search for Publisher" OnClick="ButtonPublisherSearch_Click" />
            </p>

        </div>

    </form>
</body>
</html>
