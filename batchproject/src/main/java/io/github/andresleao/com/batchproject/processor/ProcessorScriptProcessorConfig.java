package io.github.andresleao.com.batchproject.processor;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ProcessorScriptProcessorConfig {

    @Bean("processorScriptProcessor")
    public ItemProcessor<Cliente, Cliente> processorScriptProcessor() {
        return item -> {
            Path baseDir = Paths.get("C:\\raro\\batchproject\\files").toAbsolutePath();

            if (!Files.exists(baseDir)) {
                System.err.println("ERRO CRÍTICO: Diretório não existe - " + baseDir);
                return item;
            }

            String fileName = item.getEmail() + ".txt";
            Path filePath = baseDir.resolve(fileName);

            if (Files.exists(filePath)) return null;
            return item;
        };
    }

    /*
    @Bean
    public CommandLineRunner verifyDirectory() {
        return args -> {
            Path path = Paths.get("C:\\raro\\batchproject\\files").toAbsolutePath();

            System.out.println("VERIFICAÇÃO COMPLETA DO DIRETÓRIO:");
            System.out.println("Caminho absoluto: " + path);
            System.out.println("Existe? " + Files.exists(path));
            System.out.println("É diretório? " + Files.isDirectory(path));
            System.out.println("Pode ler? " + Files.isReadable(path));
            System.out.println("Pode escrever? " + Files.isWritable(path));

            System.out.println("Conteúdo real do diretório:");
            try {
                Files.list(path).forEach(p -> System.out.println(" - " + p.getFileName()));
            } catch (IOException e) {
                System.err.println("ERRO ao listar diretório: " + e.getMessage());
            }

            // Teste com um arquivo específico
            Path testFile = path.resolve("odio@Aliquamrutrum.ca.txt");
            System.out.println("\nTESTE COM ARQUIVO ESPECÍFICO:");
            System.out.println("Caminho: " + testFile);
            System.out.println("Existe? " + Files.exists(testFile));
            System.out.println("Pode ler? " + Files.isReadable(testFile));
        };
    }
     */
}
