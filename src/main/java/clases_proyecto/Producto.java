package clases_proyecto;

public class Producto {
    private String nombre;
    private String descripcion;
    private int stock;
    private float precioDeVenta;
    private float precioDeCompra;
    private float descuento;
    private int unidadesVendidas;
    private int relevancia;
    private Object categorias;
    private Object subcategoria;

    public Producto(String nombre, String descripcion, int stock, float precioDeVenta,
                    float precioDeCompra, Object categorias, Object subcategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioDeVenta = precioDeVenta;
        this.precioDeCompra = precioDeCompra;
        this.categorias = categorias;
        this.subcategoria = subcategoria;
        this.descuento = 0;
        this.relevancia = 0;
    }

    public void disminuirStock(int unidadesVendidas) {
        this.stock -= unidadesVendidas;
    }

    public void aumentarUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas += unidadesVendidas;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategorias(Object categorias) {
        this.categorias = categorias;
    }

    public void setSubcategoria(Object subcategoria) {
        this.subcategoria = subcategoria;
    }

    public int getStock() {
        return stock;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(float precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public float getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(float precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}
