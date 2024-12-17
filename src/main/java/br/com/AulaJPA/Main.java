package br.com.AulaJPA;

import java.util.List;




public class Main {
    public static void main(String[] args) {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        PlataformaDAO plataformaDAO = new PlataformaDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        // Criar e salvar uma empresa
        Empresa empresa = new Empresa();
        empresa.setNome("Tech Corp");
        empresaDAO.salvar(empresa);

       
        // Criar e salvar uma plataforma
        Plataforma plataforma1 = new Plataforma();
        plataforma1.setNome("PC");
        plataformaDAO.salvar(plataforma1);
        
        Plataforma plataforma2 = new Plataforma();
        plataforma2.setNome("CONSOLE");
        plataformaDAO.salvar(plataforma2);


     // Buscar plataforma1 e plataforma2 pelos seus IDs
        Plataforma plataforma1Buscada = plataformaDAO.buscarPorId(plataforma1.getId());
        Plataforma plataforma2Buscada = plataformaDAO.buscarPorId(plataforma2.getId());

        // Associar as plataformas à empresa
        plataforma1Buscada.setEmpresa(empresa);
        plataforma2Buscada.setEmpresa(empresa);

        // Atualizar as plataformas no banco de dados
        plataformaDAO.atualizar(plataforma1Buscada);
        plataformaDAO.atualizar(plataforma2Buscada);   
//------------------------------------------------------------------------------------------------------------------        
//------------------------------------------------------------------------------------------------------------------        
        
     // Criar e salvar uma categoria
        Categoria categoria1 = new Categoria();
        categoria1.setNome("Ação");
        categoriaDAO.salvar(categoria1);

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Aventura");
        categoriaDAO.salvar(categoria2);

        // Buscar categoria1 e categoria2 pelos seus IDs
        Categoria categoria1Buscada = categoriaDAO.buscarPorId(categoria1.getId());
        Categoria categoria2Buscada = categoriaDAO.buscarPorId(categoria2.getId());

        // Associar as categorias à empresa
        categoria1Buscada.setEmpresa(empresa);
        categoria2Buscada.setEmpresa(empresa);

        // Atualizar as categorias no banco de dados
        categoriaDAO.atualizar(categoria1Buscada);
        categoriaDAO.atualizar(categoria2Buscada);
  
        
        System.out.println("DADOS INICIAIS");
     // Buscar todas as empresas
        List<Empresa> empresas = empresaDAO.listar();

        // Para cada empresa, imprimir o nome, as plataformas e as categorias associadas
        for (Empresa emp : empresas) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
        System.out.println("Alterando uma das categorias");
        
        Categoria categoriaBuscada3 = categoriaDAO.buscarPorId(categoria2.getId());
        categoriaBuscada3.setNome("Corrida");
        categoriaDAO.atualizar(categoriaBuscada3);
        
        List<Empresa> empresas2 = empresaDAO.listar();
        
        for (Empresa emp : empresas2) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
        System.out.println("Alterando uma das plataformas");
        
        Plataforma plataformaBuscada3 = plataformaDAO.buscarPorId(plataforma2.getId());
        plataformaBuscada3.setNome("MOBILE");
        plataformaDAO.atualizar(plataformaBuscada3);
        
        List<Empresa> empresas3 = empresaDAO.listar();
        
        for (Empresa emp : empresas3) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
        System.out.println("Remover uma categoria");
        
        Categoria categoriaBuscada4 = categoriaDAO.buscarPorId(categoria1.getId());
        categoriaDAO.deletar(categoriaBuscada4.getId());
        
        List<Empresa> empresas4 = empresaDAO.listar();
        
        for (Empresa emp : empresas4) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
        System.out.println("Remover uma Plataforma");
        
        Plataforma plataformaBuscada4 = plataformaDAO.buscarPorId(plataforma1.getId());
        plataformaDAO.deletar(plataformaBuscada4.getId());
        
        List<Empresa> empresas5 = empresaDAO.listar();
        
        for (Empresa emp : empresas5) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
        System.out.println("Alterando nome da empresa");
        Empresa empresaBuscada3 = empresaDAO.buscarPorId(empresa.getId());
        empresaBuscada3.setNome("Reginaldo Corp");
        empresaDAO.atualizar(empresaBuscada3);
        
        List<Empresa> empresas7 = empresaDAO.listar();
        
        for (Empresa emp : empresas7) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
        
        System.out.println("Deletar a empresa");
        
        Empresa empresaBuscada2 = empresaDAO.buscarPorId(empresa.getId());
        empresaDAO.deletar(empresaBuscada2.getId());
        
        List<Empresa> empresas6 = empresaDAO.listar();
        
        for (Empresa emp : empresas6) {
            // Imprimir o nome da empresa
            System.out.println("Empresa: " + emp.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Plataforma plat : emp.getPlataformas()) {
                System.out.println("  Plataforma: " + plat.getNome());
            }
            // Imprimir as categorias associadas à empresa
            for (Categoria cat : emp.getCategorias()) {
                System.out.println("  Categoria: " + cat.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }
        
    } 
}
