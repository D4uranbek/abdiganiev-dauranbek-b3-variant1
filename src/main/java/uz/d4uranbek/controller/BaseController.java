package uz.d4uranbek.controller;

import lombok.RequiredArgsConstructor;
import uz.d4uranbek.SecurityContextHolder;

@RequiredArgsConstructor
public abstract class BaseController {

    protected final SecurityContextHolder security;

}
