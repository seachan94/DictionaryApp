package com.nocompany.data.mapper

import com.nocompany.data.model.WordResponse
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.WordItem

object WordEntityMapper {
    fun mapperToWordItem(response : WordResponse) : WordItem =
        WordItem(
            response.items.map{
                Items(
                    it.title,
                    it.link,
                    it.description,
                    it.thumbnail
                )
            }
        )


}