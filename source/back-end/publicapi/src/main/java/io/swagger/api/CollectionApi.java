/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.CollectionIdResult;
import io.swagger.model.CollectionInfo;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-12T09:08:16.977Z[GMT]")
@Api(value = "collection", description = "the collection API")
public interface CollectionApi {

    @ApiOperation(value = "增加题目集合", nickname = "collectionPost", notes = "添加题目集合信息", response = CollectionIdResult.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "添加成功", response = CollectionIdResult.class),
        @ApiResponse(code = 401, message = "参数格式错误") })
    @RequestMapping(value = "/collection",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<CollectionIdResult> collectionPost(@ApiParam(value = ""  )  @Valid @RequestBody CollectionInfo body);

}
