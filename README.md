# AMR-ED - Automatización OrangeHRM  
## Stack Tecnológico  
- Java 11  
- Maven  
- Selenium WebDriver  
- TestNG  

## Casos de Prueba Automatizados  
1. **Login válido**: Verifica autenticación con credenciales correctas.  
2. **Añadir empleado**: Registra un nuevo empleado en PIM.  

## Ejecución  
```bash
mvn clean test

__He tenido problemas en la parte donde hay que instalar ChromeDriver, por lo tanto no funcionan los Test (LoginTest.java y AddEmployeeTest.java)__

---

### **PASO 5: Subida a GitHub**  
**Comandos Git:**  
```bash
git clone https://github.com/AlejandroMarquezR/AMR-ED.git
cd AMR-ED
git checkout -b ACT12.1
git add .
git commit -m "Automatización OrangeHRM - Casos Login y Añadir Empleado"
git push origin ACT12.1