package LinkedList.BrowserHistory;

public class Browser
{
    Node currentPage;
    public Browser(String homepage)
    {
        this.currentPage = new Node(homepage);
    }

    public void visit(String url)
    {
        currentPage.next = null;
        Node newPage = new Node(url);
        newPage.prev = currentPage;
        currentPage.next = newPage;
        currentPage =newPage;
    }

    public String back(int steps)
    {
        while (steps>0)
        {
            if(currentPage.prev!=null)
            {
                currentPage = currentPage.prev;
            }
            else
            {
                return currentPage.data;
            }
            steps--;
        }

        return currentPage.data;
    }

    public String forward(int steps)
    {
        for(int i=0; i<steps; i++)
        {
            if(currentPage.next!=null)
            {
                currentPage = currentPage.next;
            }
            else
            {
                return currentPage.data;
            }
        }

        return currentPage.data;
    }
}
