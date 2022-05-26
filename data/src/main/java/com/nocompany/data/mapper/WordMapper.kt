package com.nocompany.data.mapper

import com.nocompany.data.model.WordResponse
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.WordItem

object WordMapper {
    fun toWordItems(response : WordResponse) : WordItem=
        WordItem(
            items = response.items.map {
                Items(
                    it.title,
                    it.description,
                    it.description,
                    it.thumbnail
                )
            }
        )
}