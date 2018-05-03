<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BookInsert.aspx.cs" Inherits="Project09_CST242.BookInsert" %>

<!DOCTYPE html>
<!-- Kemar, Woonnie, Sophia -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Book Insert</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <img src="Images/books_banner.jpg" />
        </div>

        <div style="position:absolute; top:250px; left:200px;">
            <asp:SqlDataSource ID="SqlDataSourceBook" runat="server" ConnectionString="<%$ ConnectionStrings:BooksTable %>" DeleteCommand="DELETE FROM [Book] WHERE [BookCode] = ?" InsertCommand="INSERT INTO [Book] ([BookCode], [Title], [PublisherCode], [Type], [Price]) VALUES (?, ?, ?, ?, ?)" ProviderName="<%$ ConnectionStrings:BooksTable.ProviderName %>" SelectCommand="SELECT [BookCode], [Title], [PublisherCode], [Type], [Price] FROM [Book]" UpdateCommand="UPDATE [Book] SET [Title] = ?, [PublisherCode] = ?, [Type] = ?, [Price] = ? WHERE [BookCode] = ?">
                <DeleteParameters>
                    <asp:Parameter Name="BookCode" Type="String" />
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="BookCode" Type="String" />
                    <asp:Parameter Name="Title" Type="String" />
                    <asp:Parameter Name="PublisherCode" Type="String" />
                    <asp:Parameter Name="Type" Type="String" />
                    <asp:Parameter Name="Price" Type="Decimal" />
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="Title" Type="String" />
                    <asp:Parameter Name="PublisherCode" Type="String" />
                    <asp:Parameter Name="Type" Type="String" />
                    <asp:Parameter Name="Price" Type="Decimal" />
                    <asp:Parameter Name="BookCode" Type="String" />
                </UpdateParameters>
            </asp:SqlDataSource>

            <h3>Insert a New Book</h3>

            <p>
                <asp:Label ID="Label1" runat="server" Text="Book Code:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxBookCode" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Label ID="Label2" runat="server" Text="Title:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxBookTitle" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Label ID="Label3" runat="server" Text="Publisher Code:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxPublisherCode" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Label ID="Label4" runat="server" Text="Type:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxBookType" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Label ID="Label5" runat="server" Text="Price:" Width="125px"></asp:Label>
                <asp:TextBox ID="TextBoxBookPrice" runat="server"></asp:TextBox>
            </p>

            <p>
                <asp:Button ID="ButtonInsertBook" runat="server" Text="Insert New Book" OnClick="ButtonInsertBook_Click" />
                
                <asp:Button ID="ButtonBookTable" runat="server" Text="Go Back To Book Table" OnClick="ButtonBookTable_Click" />
            </p>

            <p>
                <asp:Label ID="LabelErrorMessage" runat="server" Text=""></asp:Label>
            </p>

        </div>
    </form>
</body>
</html>
