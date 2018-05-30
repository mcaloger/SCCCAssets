package com.sccc.caloger.SCCCAssets.Controllers;

import com.sccc.caloger.SCCCAssets.DAO.CommentDAO;
import com.sccc.caloger.SCCCAssets.Models.CommentModel;
import com.sccc.caloger.SCCCAssets.Presentation.CommentPresentation;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @GetMapping("/all")
    ArrayList<CommentPresentation> getAll() throws SQLException {
        CommentDAO commentDAO = new CommentDAO();
        return commentDAO.getAll();
    }

    @GetMapping("/{commentId}")
    private CommentPresentation getOne(@PathVariable("commentId") int id) throws SQLException {
        CommentDAO commentDAO = new CommentDAO();
        return commentDAO.getOne(id);
    }

    @PostMapping("/{commentId}")
    private void update(@PathVariable("commentId") int id, @RequestBody Map<String, Object> payload) throws SQLException {
        CommentDAO commentDAO = new CommentDAO();

        CommentModel commentModel = new CommentModel();

        commentModel.setComment((String) payload.get("Comment"));

        commentDAO.updateOne(id, commentModel);
    }

    @PostMapping("/create")
    private void create(@RequestBody Map<String, Object> payload) {
        CommentDAO commentDAO = new CommentDAO();

        CommentModel commentModel = new CommentModel();
        commentModel.setAssetId((int) payload.get("assetId"));
        commentModel.setUserId((int) payload.get("userId"));
        commentModel.setComment((String) payload.get("comment"));

        commentDAO.create(commentModel);
    }
}
