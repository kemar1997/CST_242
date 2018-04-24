<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PublisherInsert.aspx.cs" Inherits="Books.PublisherInsert" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Insert Publisher</title>
</head>
<body>
    <form id="form1" runat="server">
        <img src="Images/books_banner.jpg" />
        <div style="position: absolute; top: 250px; left: 200px;">

            <asp:SqlDataSource ID="SqlDataSourcePublisher" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringBooks %>" InsertCommand="INSERT INTO [Publisher] ([PublisherCode], [Name], [City]) VALUES (?, ?, ?)" ProviderName="<%$ ConnectionStrings:ConnectionStringBooks.ProviderName %>" SelectCommand="SELECT [PublisherCode], [Name], [City] FROM [Publisher]" UpdateCommand="UPDATE [Publisher] SET [Name] = ?, [City] = ? WHERE [PublisherCode] = ?">
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

            <h3>Insert a Publisher</h3>

            <p>
                <asp:Label ID="Label1" runat="server" Text="Publisher Code:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxPublisherCode" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Label ID="Label2" runat="server" Text="Name:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxName" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Label ID="Label3" runat="server" Text="City:" Width="125"></asp:Label>
                <asp:TextBox ID="TextBoxCity" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Button ID="ButtonInsertPublisher" runat="server" Text="Insert Publisher" OnClick="ButtonInsertPublisher_Click" />

                <asp:Button ID="ButtonPublisherTable" runat="server" Text="Publisher Table" OnClick="ButtonPublisherTable_Click" />
            </p>

            <p>
                <asp:Label ID="LabelErrorMessage" runat="server"></asp:Label>
            </p>

        </div>
    </form>
</body>
</html>
