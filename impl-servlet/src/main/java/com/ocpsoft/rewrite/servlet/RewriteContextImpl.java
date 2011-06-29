/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.rewrite.servlet;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ocpsoft.rewrite.event.Rewrite;
import com.ocpsoft.rewrite.servlet.spi.InboundRewriteProducer;
import com.ocpsoft.rewrite.servlet.spi.OutboundRewriteProducer;
import com.ocpsoft.rewrite.servlet.spi.RequestCycleWrapper;
import com.ocpsoft.rewrite.servlet.spi.RewriteLifecycleListener;
import com.ocpsoft.rewrite.spi.RewriteProvider;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class RewriteContextImpl implements RewriteContext
{

   private final List<RewriteProvider<Rewrite>> providers;
   private final List<RewriteLifecycleListener<Rewrite>> listeners;
   private final List<RequestCycleWrapper<ServletRequest, ServletResponse>> wrappers;
   private final List<InboundRewriteProducer<ServletRequest, ServletResponse>> inboundProducers;
   private final List<OutboundRewriteProducer<ServletRequest, ServletResponse, Object>> outboundProducers;

   public RewriteContextImpl(final List<InboundRewriteProducer<ServletRequest, ServletResponse>> inboundProducers,
            final List<OutboundRewriteProducer<ServletRequest, ServletResponse, Object>> outboundProducers,
            final List<RewriteLifecycleListener<Rewrite>> listeners,
            final List<RequestCycleWrapper<ServletRequest, ServletResponse>> wrappers,
            final List<RewriteProvider<Rewrite>> providers)
   {
      this.inboundProducers = inboundProducers;
      this.outboundProducers = outboundProducers;
      this.listeners = listeners;
      this.wrappers = wrappers;
      this.providers = providers;
   }

   @Override
   public List<RewriteLifecycleListener<Rewrite>> getRewriteLifecycleListeners()
   {
      return listeners;
   }

   @Override
   public List<RequestCycleWrapper<ServletRequest, ServletResponse>> getRequestCycleWrappers()
   {
      return wrappers;
   }

   @Override
   public List<RewriteProvider<Rewrite>> getRewriteProviders()
   {
      return providers;
   }

   @Override
   public List<InboundRewriteProducer<ServletRequest, ServletResponse>> getInboundRewriteEventProducers()
   {
      return inboundProducers;
   }

   @Override
   public List<OutboundRewriteProducer<ServletRequest, ServletResponse, Object>> getOutboundProducers()
   {
      return outboundProducers;
   }

}
