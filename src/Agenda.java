import java.util.*;

public class Agenda {

    private Map<String, Contacto> contactos = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactoPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Error: Ya existe un contacto con el nombre " + c.getNombre());
            return;
        }
        contactos.put(c.getNombre(), c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }

    public Contacto buscarContacto(String nombre) {
        if (!contactos.containsKey(nombre)) {
            System.out.println("Contacto no encontrado: " + nombre);
        }
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        if (!contactos.containsKey(nombre)) {
            System.out.println("Contacto no encontrado: " + nombre);
            return false;
        }

        contactos.remove(nombre);
        historial.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
        for (Set<String> miembros : contactoPorGrupo.values()) {
            miembros.remove(nombre);
        }
        System.out.println("Contacto eliminado: " + nombre);

        return true;
    }

    public void listarContactos() {
        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }

    public void listarHistorial() {
        for (Contacto c : historial) {
            System.out.println(c);
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo " + nombreGrupo + " ya existe");
            return;
        }
        grupos.add(nombreGrupo);
        contactoPorGrupo.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo " + nombreGrupo + " creado");
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto " + nombreContacto + "no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo " + nombreGrupo + " no existe");
            return;
        }
        contactoPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo " + nombreGrupo);
    }

    public void listargrupos() {
        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo " + nombreGrupo + " no existe");
            return;
        }
        Set<String> miembros = contactoPorGrupo.get(nombreGrupo);
        if (miembros == null || miembros.isEmpty()) {
            System.out.println("El grupo " + nombreGrupo + " no tiene contactos");
            return;
        }

        for (String nombre : miembros) {
            Contacto contacto = contactos.get(nombre);
            if (contacto != null) {
                System.out.println(contacto);
            }
        }
    }

}
