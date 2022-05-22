package com.nocompany.data.mapper

import com.nocompany.data.model.WordResponse
import com.nocompany.domain.model.WordItem

object WordEntityMapper {
    fun mapperToWordItem(item : WordResponse) : List<WordItem> =
        item.items.map {
            WordItem(
                WordItem.Items(
                    title = it.title,
                    link = it.link,
                    description = it.description,
                    thumbnail = it.thumbnail
                )
            )
        }


}