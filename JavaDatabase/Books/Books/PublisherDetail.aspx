<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PublisherDetail.aspx.cs" Inherits="Books.PublisherDetail" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head runat="server">
    <title>Publisher Detail</title>
</head>

<body>
    <form id="form1" runat="server">

        <img src="Images/books_banner.jpg" />

        <div style="position:absolute; top:225px; left:200px;">

            <asp:SqlDataSource ID="SqlDataSourcePublisher" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringBooks %>" ProviderName="<%$ ConnectionStrings:ConnectionStringBooks.ProviderName %>" SelectCommand="SELECT * FROM [Publisher] WHERE ([PublisherCode] = ?)">
                
                <SelectParameters>
                    <asp:QueryStringParameter Name="PublisherCode" QueryStringField="PublisherCode" Type="String" />
                </SelectParameters>

            </asp:SqlDataSource>
            
            <asp:DetailsView ID="DetailsViewPublisher" runat="server" Height="50px" Width="333px" AutoGenerateRows="False" DataKeyNames="PublisherCode" DataSourceID="SqlDataSourcePublisher" CellPadding="4" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" />
                <CommandRowStyle BackColor="#D1DDF1" Font-Bold="True" />
                <EditRowStyle BackColor="#2461BF" />
                <FieldHeaderStyle BackColor="#DEE8F5" Font-Bold="True" />
                <Fields>
                    <asp:BoundField DataField="PublisherCode" HeaderText="PublisherCode" ReadOnly="True" SortExpression="PublisherCode" />
                    <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
                    <asp:BoundField DataField="City" HeaderText="City" SortExpression="City" />
                </Fields>
                <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#EFF3FB" />
            </asp:DetailsView>

            <p>
                <asp:Button ID="ButtonPublisherTable" runat="server" Text="Publisher Table" OnClick="ButtonPublisherTable_Click" />
            </p>

        </div>
        
    </form>
</body>
</html>
