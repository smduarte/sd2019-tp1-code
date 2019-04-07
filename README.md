
# Sistemas Distribuídos
### 2018/2019


## Projetos fornecidos

O repositório [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api) contém um projeto Eclipse (Java) com as interfaces dos vários serviços que compo~em o sistema.

+ **Serviço Profiles** Serviço relativo aos utilizadores; permite criar, procurar e consultar os perfis dos utilizadores registados na plataforma; permite seguir ou deixar de seguir um utilizador;
    
    
+ **Serviço Posts** Serviço relativo às publicações dos utilizadores; permite criar uma nova publicação, ou consultar uma publicação existente; permite atribuir (ou retirar) um "gosto" a uma publicação;
    
    
+ **Serviço Media Storage** Serviço focado no armazenamento das fotografias publicadas na plataforma; permite guardar uma fotografia, de modo a obter um URI/URL da mesma. Permite também obter ou apagar uma fotografia existente.


O repositório [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code) contém um projeto Eclipse (Java) com material de apoio para a realização do trabalho. A utilização deste código é opcional. O código é fornecido como forma de simplificar a realização do trabalho e fomentar boas práticas de programação.



## Funcionalidade dos serviços

O código relativo à implementação das funcionalidades dos vários serviços é disponibilizado nas seguintes classes:

+ **Serviço Profiles**

    + Interface definida na classe **microgram.api.java.Profiles** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/java/Profiles.java)<br>
    + Implementação definida na classe **microgram.impl.srv.java.JavaProfiles** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/java/JavaProfiles.java). **Nota**: estado do serviço é mantido em memória.    
    
+ **Serviço Posts**

    + Interface definida na classe **microgram.api.java.Posts** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/java/Posts.java)<br>
    + Implementação definida na classe **microgram.impl.srv.java.JavaPosts** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/java/JavaPosts.java). **Nota**: estado do serviço é mantido em memóia.
    
+ **Serviço Media Storage** 

    + Interface definida na classe **microgram.api.java.Media** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/java/Media.java)<br>
    + Implementação definida na classe **microgram.impl.srv.java.JavaMedia** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/java/JavaMedia.java). **Nota**: estado do serviço é mantido em disco.
    **Nota**: Usado como exemplos das aulas práticas.



### Exemplo - Profiles

Interface da funcionalidade do serviço Profiles:


```python
package microgram.api.java;
...
public interface Profiles {

	/**
	 * Obtains a profile
	 * @param userId unique identifier of the requested profile
	 * @return result of (OK,Profile), or NOT_FOUND
	 */
	Result<Profile> getProfile( String userId );
	
	...
}
```

Nota: todos os métodos devolve um objeto do tipo Result (que pode ser um Result.error ou um Result.ok).

Implementação da funcionalidade do serviço Profiles:


```python
package microgram.impl.srv.java;

import static microgram.api.java.Result.error;
import static microgram.api.java.Result.ok;
import static microgram.api.java.Result.ErrorCode.NOT_FOUND;
...
public class JavaProfiles extends RestResource implements microgram.api.java.Profiles {
	Map<String, Profile> users = new HashMap<>();
	Map<String, Set<String>> followers = new HashMap<>();
	Map<String, Set<String>> following = new HashMap<>();
	
	@Override
	public Result<Profile> getProfile(String userId) {
		Profile res = users.get( userId );
		if( res == null ) 
			return error(NOT_FOUND);

		res.setFollowers( followers.get(userId).size() );
		res.setFollowing( following.get(userId).size() );
		return ok(res);
	}
	...
}
```

## Código dos servidores REST

O código relativo à implementação dos servidores REST dos vários serviços é disponibilizado nas seguintes classes:

+ **Serviço Profiles**

    + Interface definida na classe **microgram.api.rest.RestProfiles** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/rest/RestProfiles.java)<br>
    + Código que inicia o servidor definido na classe **microgram.impl.srv.rest.ProfilesRestServer** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/rest/ProfilesRestServer.java).<br>
    + Recurso que implementa a interface REST do serviço definido na classe **microgram.impl.srv.rest.RestProfilesResources** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/rest/_TODO_RestProfilesResources.java). O código fornecido tem de ser renomeado e pode usar a implementação da funcionalidade do serviço (JavaProfiles).
    
+ **Serviço Posts**

    + Interface definida na classe **microgram.api.rest.RestPosts** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/rest/RestPosts.java)<br>
    + Código que inicia o servidor definido na classe **microgram.impl.srv.rest.PostsRestServer** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/rest/PostsRestServer.java).<br>
    + Recurso que implementa a interface REST do serviço definido na classe **microgram.impl.srv.rest.RestPostsResources** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/rest/_TODO_RestPostsResources.java). O código fornecido tem de ser renomeado e pode usar a implementação da funcionalidade do serviço (JavaPosts).

+ **Serviço Media Storage** 

    + Interface definida na classe **microgram.api.rest.RestMedia** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/rest/RestMediaStorage.java)<br>
    + Código que inicia o servidor definido na classe **microgram.impl.srv.rest.RestMediaStorageServer** [@ aula 4](https://github.com/smduarte/sd2019-labs/blob/master/P4-Falhas/SD2019-Labs-P4/src/impl/srv/rest/RestMediaStorageServer.java).<br>
    + Recurso que implementa a interface REST do serviço definido na classe **microgram.impl.srv.rest.RestMediaResources** [@ aula 4](https://github.com/smduarte/sd2019-labs/blob/master/P4-Falhas/SD2019-Labs-P4/src/impl/srv/rest/RestMediaResources.java).

        
Classe **microgram.impl.srv.soap.RestResource** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/rest/RestResource.java) é uma classe auxiliar com métodos genéricos para devolver resultados a partir dum objeto **Result**, usado nas classes que implementam a funcionalidade dos serviços.

### Exemplo - Profiles

Código do **RestProfilesResources**: 


```python
public class RestProfilesResources extends RestResource implements RestProfiles {

	final Profiles impl;
	
	public RestProfilesResources(URI serverUri) {
		this.impl = new JavaProfiles();
	}
	
	@Override
	public Profile getProfile(String userId) {
		return super.resultOrThrow( impl.getProfile(userId));
	}
	...
}

```

## Código dos servidores SOAP

O código relativo à implementação dos servidores SOAP dos vários serviços é disponibilizado nas seguintes classes:

+ **Serviço Profiles**

    + Interface definida na classe **microgram.api.soap.SoapProfiles** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/soap/SoapProfiles.java)<br>
    + Código que inicia o servidor definido na classe **microgram.impl.srv.soap.ProfilesSoapServer** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/soap/ProfilesSoapServer.java).<br>
    + Classe que implementa o web service do serviço definido na classe **microgram.impl.srv.soap.ProfilesWebService** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/rest/_TODO_ProfilesWebService.java). O código fornecido tem de ser renomeado e pode usar a implementação da funcionalidade do serviço (JavaProfiles).
    
+ **Serviço Posts**

    + Interface definida na classe **microgram.api.soap.SoapPosts** [sd2019-tp1-api](https://github.com/smduarte/sd2019-tp1-api/blob/master/SD2019-Microgram-API/src/microgram/api/rest/SoapPosts.java)<br>
    + Código que inicia o servidor definido na classe **microgram.impl.srv.soap.PostsSoapServer** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/soap/PostsSoapServer.java).<br>
    + Classe que implementa o web service do serviço definido na classe **microgram.impl.srv.soap.PostsWebService** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/soap/_TODO_PostsWebService.java). O código fornecido tem de ser renomeado e pode usar a implementação da funcionalidade do serviço (JavaPosts).
    
+ **Serviço Media Storage** 

    + Este serviço não será implementado em SOAP. O exercício da aula 3 serve para exemplificar como se criariam as classes com o código que inicia o servidor e com o código do web service respetivo.
        
Classe **microgram.impl.srv.soap.SoapResource** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/srv/soap/SoapResource.java) é uma classe auxiliar com métodos genéricos para devolver resultados a partir dum objeto **Result** ou lançar uma exceção **MicrogramException**, usado nas classes que implementam a funcionalidade dos serviços.

### Exemplo - Profiles

Código do **ProfilesWebService**: 


```python
package microgram.impl.srv.soap;
...
public class ProfilesWebService extends SoapService implements SoapProfiles {
	final Profiles impl;
	
	protected ProfilesWebService() {
		this.impl = new JavaProfiles();
	}
	
	@Override
	public Profile getProfile( String userId ) throws MicrogramException {
		return super.resultOrThrow( impl.getProfile(userId));
	}
	...
}

```

## Código dos clientes REST

O código relativo à implementação de clientes REST dos vários serviços é disponibilizado nas seguintes classes:

+ **Serviço Profiles**

    Código da classe que permite invocar o serviço REST Profiles: **microgram.impl.clt.rest.RestProfilesClient** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/clt/rest/_TODO_RestProfilesClient.java). Esta classe implementa a interface **Profiles**. O código fornecido tem de ser renomeado e completado.
    
+ **Serviço Posts**

    Código da classe que permite invocar o serviço REST Posts: **microgram.impl.clt.rest.RestPostsClient** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/clt/rest/_TODO_RestPostsClient.java). Esta classe implementa a interface **Posts**.  O código fornecido tem de ser renomeado e completado.
    
+ **Serviço Media Storage** 

    Código da classe que permite invocar o serviço REST Media: **microgram.impl.clt.rest.RestMediaClient** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/clt/rest/RestMediaClient.java). Esta classe implementa a interface **Media** -- ver aula prática 2. 

### Exemplo - Profiles

Código do **RestProfilesClient**: 


```python
public class RestProfilesClient extends RestClient implements Profiles {

	public RestProfilesClient(URI serverUri) {
		super(serverUri, RestProfiles.PATH);
	}

	@Override
	public Result<Profile> getProfile(String userId) {
		Response r = target.path(userId)
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get();
		return super.responseContents(r, Status.OK, new GenericType<Profile>() {});
	}
	...
	
}
```

A classe **RestClient** tem um conjunto de métodos genéricos para processar as respostas REST e convertê-las para um objeto que implementa a interface **Result**.

O pacote **microgram.impl.clt.java** tem o código para criar clientes REST que, em caso de falha de comunicação, re-executam o pedido até obter uma resposta. Ver aula 4, exercício suplementar 2, para um exemplo de como usar.


```python
public class RestMediaClient extends RestClient implements Media {
	public RestMediaClient(URI mediaStorage) {
		super(mediaStorage, RestMediaStorage.PATH);
	}

	public Result<String> upload(byte[] bytes) {
		return super.reTry(() -> _upload_v2(bytes));
	}

	Result<String> _upload_v2(byte[] bytes) {
		Response r = super.target.request().accept(MediaType.APPLICATION_JSON)
			.post(Entity.entity(bytes, MediaType.APPLICATION_OCTET_STREAM));

		return super.responseContents(r, Status.OK, new GenericType<String>() {
		});
	}
	...
}
```

## Código dos clientes SOAP

O código relativo à implementação de clientes SOAP dos vários serviços é disponibilizado nas seguintes classes:

+ **Serviço Profiles**

    Código da classe que permite invocar o serviço SOAP Profiles: **microgram.impl.clt.soap.SoapProfilesClient** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/clt/soap/_TODO_SoapProfilesClient.java). Esta classe implementa a interface **Profiles**. O código fornecido tem de ser renomeado e completado.
    
+ **Serviço Posts**

    Código da classe que permite invocar o serviço SOAP Posts: **microgram.impl.clt.soap.SoapPostsClient** [sd2019-tp1-code](https://github.com/smduarte/sd2019-tp1-code/blob/master/SD2019-Microgram-Code/src/microgram/impl/clt/rest/_TODO_SoapPostsClient.java). Esta classe implementa a interface **Posts**.  O código fornecido tem de ser renomeado e completado.
    



### Exemplo - Post

Código do **SoapPostsClient**: 


```python
public abstract class SoapPostsClient extends SoapClient implements Posts {
	SoapPosts impl;

	public SoapPostsClient() {
		this( Discovery.findUrisOf("???", 1)[0]); //TODO
	}
	
	public SoapPostsClient(URI serverUri) {
		super(serverUri);
	}

	@Override
	public Result<Post> getPost(String postId) {
		return super.tryCatchResult(() -> impl().getPost(postId));
	}
	
	private SoapPosts impl() {
		if( impl == null ) {
			//TODO
		}
		return impl;
	}
}
```

## Acesso aos servidores REST e SOAP

As classes dos clientes de REST e SOAP implementam as interfaces que definem as funcionalidades dos serviços.
Assim, é possível aceder de formar uniforme aos servidores REST e SOAP.
Ver **aula 4, exercício suplementar 2**, para ver como isso pode ser feito. 


```python
public class MediaClientFactory {

	private static final String REST = "/rest";
	private static final String SOAP = "/soap";

	public static Media getMediaClient(URI uri) {
		String uriString = uri.toString();
		if (uriString.endsWith(REST))
			return new RestMediaClient(uri);
		else if (uriString.endsWith(SOAP))
			return new SoapMediaClient(uri);

		throw new RuntimeException("Unknown service type..." + uri);
	}
}
```
