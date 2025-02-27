package com.example.zzyzzy.semiprojectv1.service;

import com.example.zzyzzy.semiprojectv1.domain.BoardDTO;
import com.example.zzyzzy.semiprojectv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardMapper;
    @Value("${board.page-size}") private int pageSize;

    @Override
    public List<BoardDTO> readBoard(int cpg) {
        int stnum = (cpg - 1) * pageSize;

        return boardMapper.selectBoard(stnum, pageSize);
    }

    @Override
    public int countBoard() {
        return boardMapper.countPagesBoard(pageSize);
    }

}
