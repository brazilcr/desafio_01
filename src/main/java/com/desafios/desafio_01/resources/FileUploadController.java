package com.desafios.desafio_01.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.desafios.desafio_01.entities.Agente;
import com.desafios.desafio_01.entities.Regiao;
import com.desafios.desafio_01.repositories.AgenteRepository;
import com.desafios.desafio_01.repositories.RegiaoRepository;
import com.desafios.desafio_01.services.FileStorageService;
import com.desafios.desafio_01.services.FileUploadResponse;
import com.desafios.desafio_01.services.FileUploadUtil;

@CrossOrigin(origins = "*")
@RestController
public class FileUploadController {

	private final FileStorageService fileStorageService;
	Agente agente = null;
	Regiao regiao = null;
	private List<Regiao> regioes = new ArrayList<Regiao>();

	@Autowired
	private AgenteRepository agenteRepository;

	@Autowired
	private RegiaoRepository regiaoRepository;

	public FileUploadController(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}

	public FileUploadController() {
		this.fileStorageService = null;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/goupload")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> uploadFile(@RequestParam(name = "file", required = false) MultipartFile file)
			throws IOException, SAXException {

		boolean isUploaded = true;
		String extension = "";
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		long size = file.getSize();
		String s = file.getOriginalFilename();
		int index = s.lastIndexOf('.');
		if (index > 0) {
			extension = s.substring(index + 1);
		}

		String filecode = FileUploadUtil.saveFile(fileName, file, extension);

		FileUploadResponse response = new FileUploadResponse();
		response.setFileName(fileName);
		response.setSize(size);
		response.setDownloadUri("uploads/files/" + filecode);

		String fileplaced = "uploads/files/" + filecode;

		Document doc = null;
		if (isUploaded) {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(fileplaced);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
			doc.getDocumentElement().normalize();

			// List<Regiao> regiao = new ArrayList<>();

			String theagente = "";
			String theregiao = "";

			NodeList nl = doc.getElementsByTagName("agentes");
			for (int i = 0; i < nl.getLength(); i++) {
				Element question = (Element) nl.item(i);
				NodeList optionList = question.getElementsByTagName("agente");
				for (int j = 0; j < optionList.getLength(); ++j) {
					Element option = (Element) optionList.item(j);
					String optionText = option.getFirstChild().getNodeValue();
					System.out.println("agente :" + optionText);
					String questionCod = option.getElementsByTagName("codigo").item(0).getTextContent();
					String tagData = option.getElementsByTagName("data").item(0).getTextContent();
					// String questionCod = option.getAttribute("codigo");
					// String tagData = option.getAttribute("data");
					theagente = questionCod;
					System.out.println("Agentes cod :" + questionCod);
					System.out.println("data :" + tagData);

					NodeList regiaoList = option.getElementsByTagName("regiao");
					for (int k = 0; k < regiaoList.getLength(); ++k) {
						Element regiaoEl = (Element) regiaoList.item(k);
						String regiaoCod = regiaoEl.getAttribute("sigla");
						theregiao = regiaoCod;
						System.out.println("regiao :" + regiaoCod);

						NodeList geraList = regiaoEl.getElementsByTagName("geracao");
						for (int l = 0; l < geraList.getLength(); ++l) {
							Element geraEl = (Element) geraList.item(l);
							System.out.println("valores geracao--------");
							NodeList valList = geraEl.getElementsByTagName("valor");
							for (int m = 0; m < valList.getLength(); ++m) {
								Element valEl = (Element) valList.item(l);
								System.out.println(" R$ " + valEl.getTextContent().trim());

								// salvar db
								Regiao r1 = new Regiao(null, theagente, null, theregiao,
										Double.parseDouble(valEl.getTextContent().trim()), null, null);
								regiaoRepository.saveAll(Arrays.asList(r1));

							}
						}

						NodeList compraList = regiaoEl.getElementsByTagName("compra");
						for (int l = 0; l < compraList.getLength(); ++l) {
							Element compraEl = (Element) compraList.item(l);
							System.out.println("valores compra--------");
							NodeList valList = compraEl.getElementsByTagName("valor");
							for (int m = 0; m < valList.getLength(); ++m) {
								Element valEl = (Element) valList.item(l);
								System.out.println(" R$ " + valEl.getTextContent().trim());

								// salvar db
								Regiao r1 = new Regiao(null, theagente, null, theregiao, null,
										Double.parseDouble(valEl.getTextContent().trim()), null);
								regiaoRepository.saveAll(Arrays.asList(r1));

							}
						}

						NodeList pmeioList = regiaoEl.getElementsByTagName("precoMedio");
						for (int l = 0; l < pmeioList.getLength(); ++l) {
							Element pmeioEl = (Element) pmeioList.item(l);
							System.out.println("valores pmedio--------");
							NodeList valList = pmeioEl.getElementsByTagName("valor");
							for (int m = 0; m < valList.getLength(); ++m) {
								Element valEl = (Element) valList.item(l);
								System.out.println(" R$ ");

								// salvar db
								Regiao r1 = new Regiao(null, theagente, null, theregiao, null, null,
										Double.parseDouble("0"));
								regiaoRepository.saveAll(Arrays.asList(r1));
							}
						}
					}
				}
			}
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Done");
	}

	@GetMapping("/getfile")
	public void handlegets() {
		System.out.println("get aqui");
	}

}