import Footer from "../components/Footer";
import Header from "../components/Header";

export default function SistemaLayout({children}:
    {children:React.ReactNode}){
    return( 
        <div className="flex min-h-screen">
          
          {/* <Sidebar /> */}
    
          {/* Esta div envolve Header, Main e Footer e os empilha verticalmente */}
          <div className="flex flex-col flex-1">
            
            <Header />
    
            {/* O flex-1 aqui é o segredo: ele estica para empurrar o footer para o fim */}
            <main className="flex-1 p-4 md:p-8">
              <div className="max-w-7xl mx-auto">
                {children}
              </div>
            </main>
    
            <Footer />
            
          </div>
        </div>
    );
}